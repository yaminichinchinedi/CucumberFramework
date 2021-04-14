package main.java.queries;

public class QUERY {
		public final static String GET_SCHEMA="select py.PAYR_SCHM_NM,py.PAYR_DSPL_NM,py.PAYR_835_ID from ole.proc_ctl pc join ole.ctl_grp cg on pc.PAYR_ALS_NM=cg.PAYR_ALS_ID join ole.CTL_GRP_PAYER cgp on cg.ctl_grp_id=cgp.ctl_grp_id join ole.PAYER py  on  cgp.PAYR_835_ID=py.PAYR_835_ID where EXTRACT_STS_CD='C'  and PROC_DT between  '{$fromDate}' and '{$toDate}'  and py.PAYR_SCHM_NM not in ('PP001') order by pc.PROC_DT desc fetch first row only";
		
		public final static String PAYMENT_TIN="Select p.prov_tax_id_nbr,cp.DSPL_CONSL_PAY_NBR,cp.CONSL_PAY_NBR, cp.setl_dt from {$schema}.CONSOLIDATED_PAYMENT cp join\r\n"+
			"{$schema}.PROVIDER p on cp.prov_key_id = p.prov_key_id join ole.product_selection ps on\r\n"+
			"p.prov_tax_id_nbr=ps.prov_tin_nbr  join OLE.PROC_CTL PC on\r\n"+
			"cp.PROC_CTL_ID= pc.PROC_CTL_ID join ole.enrolled_provider ep on\r\n"+
			"ps.prov_tin_nbr=ep.prov_tin_nbr where \r\n"+
			"cp.setl_dt between '{$fromDate}' and '{$toDate}' and (cp.ARCHV_IND is null or cp.ARCHV_IND='N')\r\n"+
			"and ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}'\r\n"+
			"and ps.PRTL_PRDCT_SELECTED_STS_CD='A' \r\n"+
			"and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A'\r\n"+
			"AND PC.EXTRACT_STS_CD = 'C'\r\n";
		

		public final static String PAYMENT_TIN_QUERY=QUERY.PAYMENT_TIN+QUERY.ENDQUERY;

		public final static String ENDQUERY="group by p.prov_tax_id_nbr,cp.DSPL_CONSL_PAY_NBR,cp.CONSL_PAY_NBR, cp.setl_dt\r\n"+

			"having count(*) between 1 and 30\r\n"+
			"order by count(*) desc\r\n"+
			"fetch first row only";
			
		public final static String ZERODOLLAR= QUERY.PAYMENT_TIN + "and cp.PAY_AMNT='0' "+QUERY.ENDQUERY;
		
		public final static String UPDATE_QUERY_FOR_FEE_REFUND1= "Update OLE.DEBIT_FEE_ACCRD dfa set dfa.DBT_FEE_ACCRD_STS = 'FC', dfa.DSPL_CONSL_PAY_NBR = '911928068', dfa.CREAT_DTTM = (SELECT CURRENT_TIMESTAMP result FROM sysibm.sysdummy1) where dfa.PROV_TIN_NBR in (Select dfa.PROV_TIN_NBR FROM OLE.DEBIT_FEE_ACCRD dfa\r\n" + 
				"JOIN OLE.DEBIT_FEE_INVCE_DTL dfid ON dfa.DBT_FEE_INVC_DTL_KEY_ID = dfid.DBT_FEE_INVC_DTL_KEY_ID\r\n" + 
				"JOIN ole.DEBIT_FEE_INVCE dfi ON dfi.DBT_FEE_INVC_KEY_ID = dfid.DBT_FEE_INVC_KEY_ID\r\n" + 
				"and not exists (select * from Ole.Debit_Fee_Refund dfr where dfr.Dbt_Fee_Key_ID=dfa.Dbt_Fee_Key_ID))\r\n" + 
				"LIMIT 10";
		
		public final static String UPDATE_QUERY_FOR_FEE_REFUND2= "Update ole.DEBIT_FEE_INVCE set INVC_SETL_DT = '{$pastDateForFeeRefund}' where PROV_TIN_NBR in (select dfa.PROV_TIN_NBR from ole.DEBIT_FEE_ACCRD dfa where dfa.DBT_FEE_ACCRD_STS = 'FC' and LST_CHG_BY_DTTM is not null \r\n" + 
				"order by LST_CHG_BY_DTTM desc)\r\n" + 
				"LIMIT 10";
		
		public final static String ENTRIES_FOR_FEE_REFUND= "Select dfa.PROV_TIN_NBR as PROV_TAX_ID_NBR, INVC_NBR as invoice_nbr, dfa.DSPL_CONSL_PAY_NBR as dspl_consl_pay_nbr, dfa.DBT_FEE_ACCRD_STS FROM OLE.DEBIT_FEE_ACCRD dfa\r\n" + 
				"JOIN OLE.DEBIT_FEE_INVCE_DTL dfid ON dfa.DBT_FEE_INVC_DTL_KEY_ID = dfid.DBT_FEE_INVC_DTL_KEY_ID\r\n" + 
				"JOIN ole.DEBIT_FEE_INVCE dfi ON dfi.DBT_FEE_INVC_KEY_ID = dfid.DBT_FEE_INVC_KEY_ID\r\n" + 
				"where dfa.DBT_FEE_ACCRD_STS = 'FC' and dfi.INVC_SETL_DT >= '{$feeRefundStartDate}'\r\n" + 
				"and not exists (select * from Ole.Debit_Fee_Refund dfr where dfr.Dbt_Fee_Key_ID=dfa.Dbt_Fee_Key_ID)\r\n" + 
				"LIMIT 1 ";
		
		public final static String EXPECTED_COUNT_FOR_FEE_REFUND_INVOICE_NUMBER= "Select count(*) as count FROM OLE.DEBIT_FEE_ACCRD dfa\r\n" + 
				"JOIN OLE.DEBIT_FEE_INVCE_DTL dfid ON dfa.DBT_FEE_INVC_DTL_KEY_ID = dfid.DBT_FEE_INVC_DTL_KEY_ID\r\n" + 
				"JOIN ole.DEBIT_FEE_INVCE dfi ON dfi.DBT_FEE_INVC_KEY_ID = dfid.DBT_FEE_INVC_KEY_ID\r\n" + 
				"WHERE dfa.DBT_FEE_ACCRD_STS = 'FC' and dfa.PROV_TIN_NBR = '{$PROV_TAX_ID_NBR}' and dfi.INVC_NBR = '{$INVOICE_NBR}'\r\n" + 
				"and dfi.INVC_SETL_DT >= '{$feeRefundStartDate}' \r\n" + 
				"and not exists (select * from Ole.Debit_Fee_Refund dfr where dfr.Dbt_Fee_Key_ID=dfa.Dbt_Fee_Key_ID)";

		public final static String EXPECTED_COUNT_FOR_FEE_REFUND_PAYMENT_NUMBER = EXPECTED_COUNT_FOR_FEE_REFUND_INVOICE_NUMBER.replace("dfi.INVC_NBR = '{$INVOICE_NBR}'","dfa.DSPL_CONSL_PAY_NBR = '{$DSPL_CONSL_PAY_NBR}'");
		
		public final static String POST_CANCELLATION_TIN_STATUS="SELECT std.* FROM \r\n" + 
				"(select ps.prov_tin_nbr as PROV_TAX_ID_NBR, ps.PRTL_PRDCT_REC_STS_CD, ps.PRTL_PRDCT_SELECTED_STS_CD, ps.cnfg_id from ole.product_selection ps\r\n" + 
				"join ole.enrolled_provider ep on  ps.prov_tin_nbr=ep.prov_tin_nbr\r\n" + 
				"where ep.enrl_sts_cd='A' and ep.pay_meth_typ_cd='AO'\r\n" + 
				"AND PRTL_PRDCT_REC_STS_CD='PS' and PRTL_PRDCT_SELECTED_STS_CD='I' and PRTL_PRDCT_SELECTED_GRP_NM='Premium')pri\r\n" + 
				"INNER JOIN \r\n" + 
				"(select * from ole.PRODUCT_SELECTION where PRTL_PRDCT_REC_STS_CD='PS' and PRTL_PRDCT_SELECTED_STS_CD='{$stdStatus}' and PRTL_PRDCT_SELECTED_GRP_NM='Standard')std\r\n" + 
				"ON pri.PROV_TAX_ID_NBR=std.PROV_TIN_NBR AND pri.PROV_TAX_ID_NBR='{$tin}'";

		public final static String PREMIUM_TRIAL_FOR_TIN="select * from ole.PRODUCT_SELECTION where PRTL_PRDCT_REC_STS_CD='TR' and PRTL_PRDCT_SELECTED_STS_CD='A' and PRTL_PRDCT_SELECTED_GRP_NM='Premium' and PROV_TIN_NBR ='{$tin}'";

		public final static String PRODUCT_SELECTION_CANCEL_RECENT ="select * from ole.Product_Selection_Cancel order by PSC_ID desc";

		public final static String DELETE_CANCELLED_TO_STANDARD_ROWS="delete from ole.PRODUCT_SELECTION where PROV_TIN_NBR ='{$tin}' and (PRTL_PRDCT_SELECTED_STS_CD='P' OR PRTL_PRDCT_SELECTED_STS_CD='A') and PRTL_PRDCT_SELECTED_GRP_NM='Standard'";

		public final static String UPDATE_CANCELLED_TO_STANDARD_ROWS="update ole.PRODUCT_SELECTION set PRTL_PRDCT_SELECTED_STS_CD='{$prdSts}' where PROV_TIN_NBR ='{$tin}' and PRTL_PRDCT_SELECTED_GRP_NM='Premium' and PRTL_PRDCT_REC_STS_CD='PS'";

		public final static String ENDQUERY_ORDER_BY_DATE=" order by ps.CREAT_DTTM desc ";

		public final static String ENDQUERY_FETCH_FIRST_ROW=" FETCH FIRST 1 ROW ONLY ";

		public final static String WITHIN_TRIAL_AND_PAID="select ps.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.product_selection ps join ole.enrolled_provider ep\r\n" + 
			"on ps.PROV_TIN_NBR=ep.PROV_TIN_NBR \r\n" + 
			" where ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAcs}' and ps.PRTL_PRDCT_REC_STS_CD='{$portalStat}' \r\n" + 
			" and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A' and\r\n" + 
			"ps.PROV_TIN_NBR in (select PROV_TIN_NBR from OLE.PRODUCT_SELECTION where PRTL_PRDCT_SELECTED_GRP_NM='Premium' and PRTL_PRDCT_SELECTED_STS_CD='A' \r\n" + 
			"and PRTL_PRDCT_REC_STS_CD='TR' ) ";

		public final static String WITHIN_TRIAL_AND_PAID_QUERY=QUERY.WITHIN_TRIAL_AND_PAID+QUERY.ENDQUERY_ORDER_BY_DATE+QUERY.ENDQUERY_FETCH_FIRST_ROW;

		public final static String NEW_ENROLL_WITHIN_TRIAL_AND_PAID_NOTPAID  = "select ps.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.product_selection ps join ole.enrolled_provider ep \r\n" + 
				"on ps.PROV_TIN_NBR=ep.PROV_TIN_NBR \r\n" + 
				" where ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAcs}' and ps.PRTL_PRDCT_REC_STS_CD='{$portalStat}' \r\n" + 
				" and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A' and \r\n" + 
				"ps.PROV_TIN_NBR in (select PROV_TIN_NBR from OLE.PRODUCT_SELECTION where PRTL_PRDCT_SELECTED_GRP_NM='Premium' and PRTL_PRDCT_SELECTED_STS_CD='A' \r\n" + 
				"and PRTL_PRDCT_REC_STS_CD='TR' and PRTL_PRDCT_SELECT_USER_TYP='ENROLLER') " + QUERY.ENDQUERY_ORDER_BY_DATE + QUERY.ENDQUERY_FETCH_FIRST_ROW ;
		
		public final static String PRODUCT_SELECTION_TIN_QUERY ="SELECT * FROM ole.PRODUCT_SELECTION WHERE PRTL_PRDCT_SELECTED_GRP_NM = '{$prdSelection}' AND PRTL_PRDCT_SELECTED_STS_CD='{$stsOfStdRecd}' AND PRTL_PRDCT_REC_STS_CD='{$SelectedOrDefault}' AND PROV_TIN_NBR='{$tin}'";

		public final static String PAYER_LIST="WITH result AS ( select  PAYR_DSPL_NM, PAYR_TIN_NBR,SORT_ORDER from OLE.PAYER p\r\n" + 
				" where PAYR_TIN_NBR in (select PAYR_TIN_NBR  from OLE.PAYER_ENROLLED_PROVIDER  where PROV_TIN_NBR= '{$Prov_tin_nbr}' ) \r\n" + 
				" and {fn TIMESTAMPDIFF( SQL_TSI_MONTH, CURRENT TIMESTAMP,LST_CHG_BY_DTTM)} <= 13 and PAYR_ACTV_IND='N'\r\n" + 
				" union \r\n" + 
				" Select PAYR_DSPL_NM, PAYR_TIN_NBR,SORT_ORDER  from OLE.PAYER  where PAYR_TIN_NBR in  \r\n" + 
				" (select PAYR_TIN_NBR from OLE.PAYER_ENROLLED_PROVIDER where PROV_TIN_NBR= '{$Prov_tin_nbr}' )  \r\n" + 
				" AND NOT PAYR_DSPL_NM='US Dept of Health and Human Services' and PAYR_ACTV_IND='Y' ORDER BY SORT_ORDER ASC , PAYR_DSPL_NM)\r\n" + 
				"SELECT\r\n" + 
				"    *,\r\n" + 
				"    (SELECT COUNT(*) FROM result) AS TotalRows\r\n" + 
				"FROM result";
		
		public final static String EPRA_TIN_QUERY_Row_204 = "SELECT * FROM\r\n" + 
				"(\r\n" + 
				"-- For ranking the records\r\n" + 
				"SELECT PROV_TIN_NBR as PROV_TAX_ID_NBR, USER_TYP, STS_CD,PROV_NPI_NBR,LST_NM,SBSCR_ID,PTNT_FST_NM,PTNT_LST_NM,PTNT_ACCT_NBR,CLM_NBR, DSPL_CONSL_PAY_NBR, CONSL_PAY_NBR, SETL_DT, PAYR_SCHM_NM, PAYR_835_ID, CLAIMCOUNT, PORTAL_USER_ID, USERNAME, 'Performance_2252017' AS EPSPWD, OPTUMID, 'Payables@125' AS OPTUMPWD,\r\n" + 
				"ROW_NUMBER() OVER (PARTITION BY PROV_TIN_NBR, USER_TYP, STS_CD,PROV_NPI_NBR,LST_NM,SBSCR_ID,PTNT_FST_NM,PTNT_LST_NM,PTNT_ACCT_NBR,CLM_NBR,DSPL_CONSL_PAY_NBR, CONSL_PAY_NBR, SETL_DT, PAYR_SCHM_NM, PAYR_835_ID, CLAIMCOUNT ORDER BY PORTAL_USER_ID, USERNAME, OPTUMID) AS USER_RANK\r\n" + 
				"\r\n" + 
				"FROM (\r\n" + 
				"-- Main SQL that extracts the data\r\n" + 
				"SELECT PU.PORTAL_USER_ID, PU.USERNAME, TRIM(PU.SSO_ID) AS OPTUMID, PUT.PROV_TIN_NBR, PU.USER_TYP, PU.STS_CD,\r\n" + 
				"SC.CP_DSPL_CONSL_PAY_NBR AS DSPL_CONSL_PAY_NBR, SC.UCP_CONSL_PAY_NBR AS CONSL_PAY_NBR, TO_CHAR(SC.CP_SETL_DT,'MM/DD/YYYY') as SETL_DT, SC.PAYR_SCHM_NM, SC.PYR_SEC_PAYR_ID AS PAYR_835_ID,\r\n" + 
				"SC.PROV_NPI_NBR,SCL.RP_UPPER_LST_NM as LST_NM,SCL.SUB_SBSCR_ID as SBSCR_ID, SCL.CLM_PTNT_FST_NM as PTNT_FST_NM, SCL.CLM_PTNT_LST_NM as PTNT_LST_NM,\r\n" + 
				"SCL.CLM_PTNT_ACCT_NBR as PTNT_ACCT_NBR, SCL.CLM_NBR as CLM_NBR,\r\n" + 
				"COUNT(DISTINCT SCL.CLM_KEY_ID) as CLAIMCOUNT\r\n" + 
				"FROM OLE.PORTAL_USER PU, OLE.PORTAL_USER_TIN PUT, OLE.EPRA_STATUS EP, OLE.SRCH_CONSOL_TBL SC, OLE.SRCH_CLAIM_TBL SCL\r\n" + 
				"WHERE PU.PORTAL_USER_ID = PUT.PORTAL_USER_ID -- Join PU with PUT\r\n" + 
				"AND PUT.PROV_TIN_NBR=SC.PROV_TAX_ID_NBR-- Join SC with PUT\r\n" + 
				"AND SC.UCP_UCONSL_PAY_KEY_ID = SCL.CUP_UCONSL_PAY_KEY_ID-- Join SC with SCL\r\n" + 
				"AND SC.PAYR_SCHM_NM=SCL.PAYR_SCHM_NM-- Join SC with SCL- Payer\r\n" + 
				"AND SC.PAYR_SCHM_NM = 'PP008'-- <<Change Payer Schema Name here>>\r\n" + 
				"AND SC.CP_SETL_DT BETWEEN '2020-03-01' AND '2020-05-15' -- <<Change Claim Settlement Date range here >>\r\n" + 
				"AND PU.STS_CD='A'\r\n" + 
				"AND PU.USER_TYP='P'\r\n" + 
				"AND EP.PRIORITY = '{$priority}'\r\n" + 
				"AND SCL.RP_UPPER_LST_NM != '' \r\n" + 
				"AND SC.UCP_CONSL_PAY_NBR NOT IN \r\n" + 
				"(SELECT DISTINCT EP.CONSL_PAY_NBR FROM OLE.EPRA_STATUS EP WHERE EP.CONSL_PAY_NBR=SC.UCP_CONSL_PAY_NBR)-- Payment ID shouldn't exist in EPRA_STATUS\r\n" + 
				"AND PU.SSO_ID = '{$id}'\r\n" + 
				"GROUP BY PU.PORTAL_USER_ID, PU.USERNAME, PU.SSO_ID, PUT.PROV_TIN_NBR, PU.USER_TYP, PU.STS_CD,\r\n" + 
				"SC.CP_DSPL_CONSL_PAY_NBR, SC.UCP_CONSL_PAY_NBR, TO_CHAR(SC.CP_SETL_DT,'MM/DD/YYYY'), SC.PAYR_SCHM_NM, SC.PYR_SEC_PAYR_ID,\r\n" + 
				"SC.PROV_NPI_NBR,SCL.RP_UPPER_LST_NM,SCL.SUB_SBSCR_ID , SCL.CLM_PTNT_FST_NM , SCL.CLM_PTNT_LST_NM ,\r\n" + 
				"SCL.CLM_PTNT_ACCT_NBR , SCL.CLM_NBR \r\n" + 
				"HAVING COUNT(DISTINCT SCL.CLM_KEY_ID) BETWEEN 1 AND 10  -- << Change the claim count range here >>\r\n" + 
				"----FETCH FIRST  ROW ONLY\r\n" + 
				")\r\n" + 
				")DUPLUSR\r\n" + 
				"WHERE DUPLUSR.USER_RANK=1 AND LST_NM != '' AND PROV_NPI_NBR IS NOT NULL\r\n" + 
				"ORDER BY SETL_DT DESC\r\n" + 
				"fetch first row only\r\n";
		
		public final static String EPRAGenerated_TIN_QUERY_Row_205 = "select sc.Payr_schm_nm, sc.CP_DSPL_CONSL_PAY_NBR as DSPL_CONSL_PAY_NBR, sc.CP_SETL_DT as SETL_DT, sc.UCP_CONSL_PAY_NBR as CONSL_PAY_NBR,\r\n" + 
				"sc.PROV_NPI_NBR, sc.PROV_TAX_ID_NBR, es.claim_cnt, ct.clm_nbr, ct.CLM_PTNT_ACCT_NBR as PTNT_ACCT_NBR,ct.SUB_SBSCR_ID as SBSCR_ID, ct.CLM_PTNT_FST_NM as PTNT_FST_NM, ct.CLM_PTNT_LST_NM as PTNT_LST_NM,\r\n" + 
				"ct.RP_UPPER_LST_NM as LST_NM\r\n" + 
				"from ole.srch_consol_tbl sc, ole.epra_status es, ole.srch_claim_tbl ct\r\n" + 
				"where es.REQ_STS = 'C' and es.PRIORITY =  '{$priority}'\r\n" + 
				"and sc.ucp_consl_pay_nbr = es.consl_pay_nbr\r\n" + 
				"and sc.UCP_UCONSL_PAY_KEY_ID = ct.CUP_UCONSL_PAY_KEY_ID\r\n" + 
				"and sc.PAYR_SCHM_NM='PP008'\r\n" + 
				"and sc.prov_tax_id_nbr in (select PROV_TIN_NBR from ole.PORTAL_USER_TIN where PORTAL_USER_ID in (select PORTAL_USER_ID from ole.PORTAL_USER where sso_id = '{$id}'))\r\n" + 
				"and ct.RP_UPPER_LST_NM != '' AND es.claim_cnt IS NOT NULL AND sc.PROV_NPI_NBR IS NOT NULL\r\n" + 
				"order by sc.CP_SETL_DT desc\r\n" + 
				"fetch first 1 row only\r\n" ;
		
		public final static String DELETE_ALL_TINS_FOR_USER ="DELETE FROM ole.PRODUCT_SELECTION ps \r\n" + 
				"where  ps.PROV_TIN_NBR in (select put.PROV_TIN_NBR from ole.PORTAL_USER_TIN put INNER JOIN ole.PORTAL_USER pu ON pu.PORTAL_USER_ID = put.PORTAL_USER_ID WHERE ACCESS_LVL='A' AND SSO_ID = '{$id}')";
		
		public final static String INSERT_ALL_STD_TRIAL_TINS_FOR_USER="INSERT INTO ole.product_selection (PROV_TIN_NBR,PRTL_PRDCT_SELECTED_GRP_NM,PRTL_PRDCT_SELECTED_CD,PRTL_PRDCT_SELECTED_STS_CD,PRTL_PRDCT_SELECT_EFF_DTTM,PRTL_PRDCT_SELECT_USERID,PRTL_PRDCT_SELECT_USER_FULLNAME,PRTL_PRDCT_SELECT_USER_TYP,PRTL_PRDCT_SELECT_DTTM,CREAT_BY_ID,CREAT_DTTM,CREAT_BY_PRTL_ID,LST_CHG_BY_ID,LST_CHG_BY_DTTM,LST_CHG_BY_PRTL_ID,PRTL_PRDCT_REC_STS_CD)  \r\n" + 
				"VALUES ('{$tin}', 'Premium', 'P', 'A', CURRENT date, 'SYSTEM', 'SYSTEM', 'SYSTEM', CURRENT date, 'SYSTEM', CURRENT date, 'AllPayerPortal', 'SYSTEM', CURRENT date, 'Automation', 'TR'), \r\n" + 
				"('{$tin}', 'Standard', 'F', 'P', CURRENT date+30, 'SYSTEM', 'SYSTEM', 'SYSTEM', CURRENT date+30, 'SYSTEM', CURRENT date+30, 'AllPayerPortal', 'SYSTEM', CURRENT date+30, 'Automation', 'PD')\r";
		
}
