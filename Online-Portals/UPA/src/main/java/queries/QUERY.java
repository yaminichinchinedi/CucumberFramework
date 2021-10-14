
package main.java.queries;

public class QUERY {
		public final static String GET_SCHEMA="select py.PAYR_SCHM_NM,py.PAYR_DSPL_NM,py.PAYR_835_ID from ole.proc_ctl pc join ole.ctl_grp cg on pc.PAYR_ALS_NM=cg.PAYR_ALS_ID join ole.CTL_GRP_PAYER cgp on cg.ctl_grp_id=cgp.ctl_grp_id join ole.PAYER py  on  cgp.PAYR_835_ID=py.PAYR_835_ID where EXTRACT_STS_CD='C'  and PROC_DT between  '{$fromDate}' and '{$toDate}'  and py.PAYR_SCHM_NM not in ('PP001') order by pc.PROC_DT desc fetch first row only";
		
		public final static String GET_SCHEMA_PAYER="select py.PAYR_SCHM_NM,py.PAYR_DSPL_NM,py.PAYR_835_ID from ole.proc_ctl pc join ole.ctl_grp cg on pc.PAYR_ALS_NM=cg.PAYR_ALS_ID join ole.CTL_GRP_PAYER cgp on cg.ctl_grp_id=cgp.ctl_grp_id join ole.PAYER py  on  cgp.PAYR_835_ID=py.PAYR_835_ID where EXTRACT_STS_CD='C'  and PROC_DT between  '{$fromDate}' and '{$toDate}'  and py.PAYR_SCHM_NM not in ('PP001') order by pc.PROC_DT desc fetch first row only";
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
		
public final static String PAYR_DETAILS_FOR_PAYR_USER="SELECT * from OLE.PORTAL_USER pu INNER JOIN OLE.PORTAL_USER_PAYER_TIN pt on pu.PORTAL_USER_ID = pt.PORTAL_USER_ID INNER JOIN OLE.PAYER py ON pt.PAYR_TIN_NBR = py.PAYR_TIN_NBR WHERE pu.SSO_ID='{$id}'";
		public final static String PAST_DUE_ACCRUED_FEE="SELECT  SUM(dba.DBT_FEE_ACCRD_AMT) as DBT_FEE_ACCRD_AMT  FROM OLE.DEBIT_FEE_ACCRD dba WHERE  dba.prov_tin_nbr='{$tin}' and dba.SETL_DT> current date -day(current date) -1 days and dba.SETL_DT <= last_day(current date) and dba.SETL_DT <= current date and DBT_FEE_ACCRD_STS in ('FA' ,'FZ')";
		public final static String TIN_WITH_DEBIT_ACCRD_FEE="select dfi.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.DEBIT_FEE_ACCRD dfi,OLE.ENROLLED_PROVIDER ep,OLE.PRODUCT_SELECTION ps \r\n" +
				"where  dfi.PROV_TIN_NBR=ep.PROV_TIN_NBR  and\r\n" +
				"dfi.PROV_TIN_NBR=ps.PROV_TIN_NBR and ps.PRTL_PRDCT_SELECTED_GRP_NM='Premium' and ps.PRTL_PRDCT_SELECTED_STS_CD='A' and  ep.PAY_METH_TYP_CD='AO'\r\n" +
				"and PRTL_PRDCT_REC_STS_CD='PS' \r\n" +
				"and ep.ENRL_STS_CD='A' and DBT_FEE_ACCRD_AMT {$nullStatus}\r\n" +
				"and dfi.SETL_DT>current date\r\n" +
				"order by dfi.PROC_DT desc \r\n" +
				"fetch first 1 rows only with ur";
		public final static String PAYMENT_TIN_QUERY=QUERY.PAYMENT_TIN+QUERY.ENDQUERY;

		public final static String ENDQUERY="group by p.prov_tax_id_nbr,cp.DSPL_CONSL_PAY_NBR,cp.CONSL_PAY_NBR, cp.setl_dt\r\n"+

			"having count(*) between 1 and 30\r\n"+
			"order by count(*) desc,cp.setl_dt desc\r\n"+
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

		public final static String WITHIN_TRIAL_AND_PAID_NOTPAID="select ps.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.product_selection ps join ole.enrolled_provider ep\r\n" + 
			"on ps.PROV_TIN_NBR=ep.PROV_TIN_NBR \r\n" + 
			" where ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAcs}' and ps.PRTL_PRDCT_REC_STS_CD='{$portalStat}' and ps.PRTL_PRDCT_SELECTED_STS_CD='P' \r\n" + 
			" and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A' and\r\n" + 
			"ps.PROV_TIN_NBR in (select PROV_TIN_NBR from OLE.PRODUCT_SELECTION where PRTL_PRDCT_SELECTED_GRP_NM='Premium' and PRTL_PRDCT_SELECTED_STS_CD='A' \r\n" + 
			"and PRTL_PRDCT_REC_STS_CD='TR' ) ";

		public final static String WITHIN_TRIAL_AND_PAID_NOTPAID_QUERY=QUERY.WITHIN_TRIAL_AND_PAID_NOTPAID+QUERY.ENDQUERY_ORDER_BY_DATE+QUERY.ENDQUERY_FETCH_FIRST_ROW;

		public final static String NEW_ENROLL_WITHIN_TRIAL_AND_PAID_NOTPAID  = "select ps.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.product_selection ps join ole.enrolled_provider ep \r\n" + 
				"on ps.PROV_TIN_NBR=ep.PROV_TIN_NBR \r\n" + 
				" where ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAcs}' and ps.PRTL_PRDCT_REC_STS_CD='{$portalStat}' \r\n" + 
				" and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A' and \r\n" + 
				"ps.PROV_TIN_NBR in (select PROV_TIN_NBR from OLE.PRODUCT_SELECTION where PRTL_PRDCT_SELECTED_GRP_NM='Premium' and PRTL_PRDCT_SELECTED_STS_CD='A' \r\n" + 
				"and PRTL_PRDCT_REC_STS_CD='TR' and PRTL_PRDCT_SELECT_USER_TYP='ENROLLER') " + QUERY.ENDQUERY_ORDER_BY_DATE + QUERY.ENDQUERY_FETCH_FIRST_ROW ;
		
		public final static String PRODUCT_SELECTION_TIN_QUERY ="SELECT * FROM ole.PRODUCT_SELECTION WHERE PRTL_PRDCT_SELECTED_GRP_NM = '{$prdSelection}' AND PRTL_PRDCT_SELECTED_STS_CD='{$stsOfStdRecd}' AND PRTL_PRDCT_REC_STS_CD='{$SelectedOrDefault}' AND PROV_TIN_NBR='{$tin}'";
		public final static String POST_TRIAL_AND_PAID_NOTPAID="select ps.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.product_selection ps \r\n" + 
				"inner join ole.enrolled_provider ep on ps.PROV_TIN_NBR=ep.PROV_TIN_NBR \r\n" + 
				"inner join OLE.SRCH_CONSOL_TBL sc on ps.PROV_TIN_NBR=sc.PROV_TAX_ID_NBR \r\n" + 
				"where ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAcs}' and ps.PRTL_PRDCT_REC_STS_CD='{$portalStat}' and ps.PRTL_PRDCT_SELECTED_STS_CD='A' and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A'";

	    public final static String POST_TRIAL_AND_PAID_NOTPAID_QUERY=QUERY.POST_TRIAL_AND_PAID_NOTPAID+QUERY.ENDQUERY_ORDER_BY_DATE+QUERY.ENDQUERY_FETCH_FIRST_ROW;

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
		
		public static final String GET_TIN_PAYMENT_NUMBER_FOR_MULTIPLE_PLB_ADJUSTMENTS = "Select DISTINCT PROV_TAX_ID_NBR, UCP_CONSL_PAY_NBR from OLE.SRCH_CONSOL_TBL where CP_DSPL_CONSL_PAY_NBR IN\n" +
				"(Select DISTINCT CP_DSPL_CONSL_PAY_NBR from OLE.SRCH_CONSOL_TBL where UCP_CONSL_PAY_NBR in (SELECT CONSL_PAY_NBR\n" +
				"FROM PP001.PROVIDER_PAYOR_ADJUSTMENT\n" +
				"GROUP BY CONSL_PAY_NBR\n" +
				"HAVING COUNT(*) = 4\n" +
				"ORDER BY CONSL_PAY_NBR ASC LIMIT 1))";

		public static final String GET_TIN_PAYMENT_NUMBER_FOR_PLB_ADJUSTMENTS = "Select DISTINCT PROV_TAX_ID_NBR, UCP_CONSL_PAY_NBR from OLE.SRCH_CONSOL_TBL where CP_DSPL_CONSL_PAY_NBR IN\n" +
				"(Select DISTINCT CP_DSPL_CONSL_PAY_NBR from OLE.SRCH_CONSOL_TBL where UCP_CONSL_PAY_NBR in (SELECT CONSL_PAY_NBR\n" +
				"FROM PP001.PROVIDER_PAYOR_ADJUSTMENT\n" +
				"GROUP BY CONSL_PAY_NBR\n" +
				"HAVING COUNT(*) = 2\n" +
				"ORDER BY CONSL_PAY_NBR ASC LIMIT 1))";

		public static final String GET_CONSL_PAY_NBR_FOR_REMITTANCE_DETAIL = "SELECT SC.CP_DSPL_CONSL_PAY_NBR, PA.CONSL_PAY_NBR\n" +
				"FROM OLE.SRCH_CONSOL_TBL SC\n" +
				"LEFT JOIN PP001.PROVIDER_PAYOR_ADJUSTMENT PA ON SC.UCP_CONSL_PAY_NBR = PA.CONSL_PAY_NBR\n" +
				"WHERE PROV_TAX_ID_NBR = '{$tin}'\n" +
				"ORDER BY SC.CP_SETL_DT DESC\n" +
				"FETCH FIRST ROW ONLY";

		public static final String GET_PAYER_SCHEMA = "(Select DISTINCT PAYR_SCHM_NM from OLE.PAYER where PAYR_835_ID IN \n" +
				"(Select DISTINCT PAYR_835_ID from OLE.SUB_PAYER where SUB_PAYR_DSPL_NM = '{$ui_Payer}'))";

		public static final String GET_UCP_CONSOLIDATED_PAYMENT_NUMBER = "Select DISTINCT UCP_CONSL_PAY_NBR from OLE.SRCH_CONSOL_TBL where CP_DSPL_CONSL_PAY_NBR = '{$cpDsplConslPayNbr}'";

		public static final String GET_PLB_DATA_FROM_DB = "Select PROV_ADJ_RSN_CD,PROV_ADJ_ID,PROV_PAYR_ADJ_AMT from PP001.PROVIDER_PAYOR_ADJUSTMENT WHERE CONSL_PAY_NBR = '{$ucpConsolidatedPaymentNumber}'";
		
		public static final String GET_CHECK_NUMBER_AND_TIN = "select cpd.CHK_NBR as CHECK_NBR,p.PROV_TAX_ID_NBR\n" +
				"from PP001.PROVIDER p, PP001.UNCONSOLIDATED_PAYMENT ucp,PP001.CONSOLIDATED_PAYMENT cp,\n" +
				"OLE.PROC_CTL pc,\n" +
				"PP001.CONSL_PAY_DTL cpd,\n" +
				"OLE.ENROLLED_PROVIDER e\n" +
				"where \n" +
				"p.PROV_TAX_ID_NBR=e.PROV_TIN_NBR \n" +
				"and cpd.CONSL_PAY_NBR = ucp.CONSL_PAY_NBR\n" +
				"and p.PROV_KEY_ID =ucp.PROV_KEY_ID \n" +
				"and cp.PROC_CTL_ID=pc.PROC_CTL_ID \n" +
				"and e.ENRL_STS_CD='A' \n" +
				"and pc.EXTRACT_STS_CD='C' \n" +
				"and cpd.CHK_NBR is not null\n" +
				"and cp.setl_dt between current date - 6 MONTHS and current date\n" +
				"fetch first row only with ur";
		
		 public static final String Enhancement_Invoice_Grid_Data = "SELECT dfi.Prov_Tin_Nbr, dfi.BILL_CYC_STRT_DT, dfi.BILL_CYC_END_DT, dfi.INVC_TOT_AMT, dfi.INVC_NBR, dfi.INVC_STS, dfi.PAID_DATE, dfi.PAID_BY_USER, dfi.CONFIRM_NBR, pu.FST_NM, pu.LST_NM\r\n" + 
			  		"FROM OLE.DEBIT_FEE_INVCE dfi\r\n" + 
			  		"LEFT JOIN OLE.PORTAL_USER pu ON pu.PORTAL_USER_ID = dfi.PAID_BY_USER\r\n" + 
			  		"WHERE dfi.INVC_STS <> 'IC' AND INVC_TYP = 'PPP' AND PROV_TIN_NBR = '{$tin}'\r\n" + 
			  		"Order by BILL_CYC_STRT_DT desc";
		
		public final static String TIN_WITH_INVOICE="SELECT dfi.PROV_TIN_NBR as PROV_TAX_ID_NBR FROM ole.DEBIT_FEE_INVCE dfi, OLE.ENROLLED_PROVIDER ep, ole.PRODUCT_SELECTION ps, ole.PRODUCT_CONFIGURATION pc WHERE\r\n" +
				"pc.GROUP_NM=ps.PRTL_PRDCT_SELECTED_GRP_NM\r\n" + 
				"AND dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR \r\n" + 
				"AND ep.PAY_METH_TYP_CD='{$tinType}'\r\n" + 
				"AND ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}'\r\n" + 
				"AND ep.ENRL_STS_CD='A'\r\n" + 
				"AND dfi.INVC_TOT_AMT > 0 AND dfi.INVC_STS = 'IR'\r\n" + 
				"fetch first 1 rows only with ur";
		
		public final static String UPDATE_ABA_VALIDATOR_SWITCH = "UPDATE OLE.SYSTEM_CONFIGURATION SET PROC_DATA = '{$proc_data}' WHERE PROC_CD = 'ABA_API'\r\n";


		public final static String TOTAL_ACCRUED_FEES = "Select SUM(DBT_FEE_ACCRD_AMT) as ACCRDFEE from OLE.DEBIT_FEE_ACCRD dfa where PROV_TIN_NBR='{$tin}' AND dfa.SETL_DT between CURRENT_DATE - (DAY(CURRENT_DATE)-1) DAYS and CURRENT_DATE ";
		
		public final static String UPDATED_DEBIT_FEE_INVCE="Select * from OLE.DEBIT_FEE_INVCE where PROV_TIN_NBR='{$tin}' and INVC_NBR='{$invc_nbr}' order by LST_CHG_BY_DTTM desc fetch first 1 rows only with ur";

		public final static String DATE_OF_PAYMENT="SELECT p.PROV_TAX_ID_NBR,sr.SBSCR_ID, cp.SETL_DT, p.PROV_NPI_NBR, c.CLM_NBR, c.PTNT_ACCT_NBR, c.PTNT_FST_NM, c.PTNT_LST_NM, c.CLM_STRT_DT, c.CLM_END_DT\n" +
				"from {$schema}.CONSOLIDATED_PAYMENT cp, \n" +
				"OLE.ENROLLED_PROVIDER ep, OLE.product_selection ps, OLE.PRODUCT_CONFIGURATION pc,\n" +
				"{$schema}.PROVIDER p,{$schema}.CLAIM c, {$schema}.UNCONSOLIDATED_PAYMENT ucp, {$schema}.SUBSCRIBER sr, {$schema}.CLAIM_UNCONSOLIDATED_PAYMENT cup,OLE.PROC_CTL PRC \n" +
				"WHERE cp.prov_key_id = p.prov_key_id \n" +
				"AND p.PROV_TAX_ID_NBR=ep.PROV_TIN_NBR \n" +
				"AND ps.PROV_TIN_NBR=ep.PROV_TIN_NBR\n" +
				"AND pc.GROUP_NM=ps.PRTL_PRDCT_SELECTED_GRP_NM\n" +
				"AND ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}'\n" +
				"AND ps.PRTL_PRDCT_SELECTED_STS_CD='A'\n" +
				"AND ep.PAY_METH_TYP_CD='{$tinType}'\n" +
				"AND PRC.PROC_CTL_ID = cp.PROC_CTL_ID\n" +
				"AND cp.CONSL_PAY_NBR = ucp.CONSL_PAY_NBR\n" +
				"AND ucp.UCONSL_PAY_KEY_ID = cup.UCONSL_PAY_KEY_ID\n" +
				"AND cup.CLM_KEY_ID = c.CLM_KEY_ID  \n" +
				"AND c.SBSCR_KEY_ID = sr.SBSCR_KEY_ID \n" +
				"AND p.PROV_NPI_NBR is not null\n" +
				"AND ep.ENRL_STS_CD='A'\n" +
				"AND PRC.EXTRACT_STS_CD = 'C'\n" +
				"AND cp.SETL_DT between (current date - 30 days) AND current date \n" +
				"order by cp.SETL_DT";
	

		public final static String TIN_WITH_ACCRD_FEE="SELECT dfa.PROV_TIN_NBR as PROV_TAX_ID_NBR,ps.CNFG_ID,ps.PRTL_PRDCT_REC_STS_CD FROM OLE.DEBIT_FEE_ACCRD dfa,OLE.PRODUCT_SELECTION ps, OLE.ENROLLED_PROVIDER ep \r\n"+
		        "WHERE ps.PROV_TIN_NBR=dfa.PROV_TIN_NBR AND dfa.PROV_TIN_NBR = ep.PROV_TIN_NBR AND ep.PAY_METH_TYP_CD='{$tinType}' AND ps.PRTL_PRDCT_SELECTED_GRP_NM='Premium' AND  PRTL_PRDCT_SELECTED_STS_CD='A' \r\n"
				+"and dfa.DBT_FEE_ACCRD_AMT is not null AND dfa.PROC_DT between CURRENT_DATE - (DAY(CURRENT_DATE)-1) DAYS and LAST_DAY(CURRENT DATE) order by dfa.PROV_TIN_NBR desc fetch first 1 rows only with ur";
		
		public final static String UPDATE_PRODUCT_SELECTION = "UPDATE OLE.PRODUCT_SELECTION SET PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}',PRTL_PRDCT_SELECTED_STS_CD='A',PRTL_PRDCT_REC_STS_CD='{$prtl_prdct_selected_sts_cd}' where CNFG_ID ='{$cnfg_id}' ";
		public final static String UPDATE_ENROLLED_PROVIDER_PAY_MTHD = "UPDATE OLE.ENROLLED_PROVIDER set PAY_METH_TYP_CD='{$tinType}' where PROV_TIN_NBR = ='{$tin}' ";

		public final static String TIN_WITH_REFUND_INVOICE="SELECT dfi.PROV_TIN_NBR as PROV_TAX_ID_NBR , dfi.INVC_NBR as INVC_NBR FROM ole.DEBIT_FEE_INVCE dfi, OLE.ENROLLED_PROVIDER ep, ole.PRODUCT_SELECTION ps, ole.PRODUCT_CONFIGURATION pc WHERE\r\n" +
				"pc.GROUP_NM=ps.PRTL_PRDCT_SELECTED_GRP_NM\r\n" + 
				"AND dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR \r\n" + 
				"AND ep.PAY_METH_TYP_CD='{$tinType}'\r\n" + 
				"AND ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}'\r\n" + 
				"AND ep.ENRL_STS_CD='A'\r\n" + 
				"AND dfi.INVC_TOT_AMT < 0 AND dfi.INVC_STS = 'IR'\r\n";
		public final static String TIN_WITH_FAILED_INVOICE="SELECT dfi.PROV_TIN_NBR as PROV_TAX_ID_NBR , dfi.INVC_NBR as INVC_NBR , dfi.BANK_ACCT_NBR as BANK_ACCT_NBR FROM ole.DEBIT_FEE_INVCE dfi, OLE.ENROLLED_PROVIDER ep, ole.PRODUCT_SELECTION ps, ole.PRODUCT_CONFIGURATION pc WHERE\r\n" +
				"pc.GROUP_NM=ps.PRTL_PRDCT_SELECTED_GRP_NM\r\n" + 
				"AND dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR \r\n" + 
				"AND ep.PAY_METH_TYP_CD='{$tinType}'\r\n" + 
				"AND ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}'\r\n" + 
				"AND ep.ENRL_STS_CD='A'\r\n" + 
				"AND dfi.INVC_STS = 'FP'\r\n" +
				"order by INVC_NBR desc";
		
		 public static final String INVOICE_SEARCH = "SELECT dfi.Prov_Tin_Nbr, dfi.BILL_CYC_STRT_DT, dfi.BILL_CYC_END_DT, dfi.INVC_TOT_AMT, dfi.INVC_NBR as INVC_NBR, dfi.INVC_STS, dfi.PAID_DATE, dfi.PAID_BY_USER, dfi.CONFIRM_NBR\r\n" + 
			  		"FROM OLE.DEBIT_FEE_INVCE dfi\r\n" + 
			  		"WHERE INVC_TYP = 'PPP' AND PROV_TIN_NBR = '{$tin}'\r\n";
		 public static final String INVOICE_SEARCH_REFUND =INVOICE_SEARCH+"AND dfi.INVC_STS ='IR'AND dfi.INVC_TOT_AMT < 0";

         public final static String TIN_WITH_WAVIE ="   SELECT DFA.PROV_TIN_NBR AS PROV_TAX_ID_NBR,SUM(DFA.DBT_FEE_ACCRD_AMT) AS DBT_FEE_ACCRD_AMT\r\n" +
                 "                FROM OLE.DEBIT_FEE_ACCRD DFA\r\n" +
                 "                JOIN OLE.PRODUCT_SELECTION PS ON PS.PROV_TIN_NBR = DFA.PROV_TIN_NBR\r\n" +
                 "                JOIN OLE.ENROLLED_PROVIDER EP ON EP.PROV_TIN_NBR = PS.PROV_TIN_NBR\r\n" +
                 "                WHERE DFA.DBT_FEE_ACCRD_AMT > '0.0' AND PS.PRTL_PRDCT_SELECTED_GRP_NM = '{$portalAccess}' AND PRTL_PRDCT_SELECTED_CD = 'P' AND\r\n" +
                 "                PS.PRTL_PRDCT_SELECTED_STS_CD = 'A' AND PS.PRTL_PRDCT_SELECTED_CD = 'P' AND EP.PAY_METH_TYP_CD = '{$tinType}' AND EP.ENRL_STS_CD = 'A' AND DFA.PROV_TIN_NBR NOT IN (\r\n" +
                 "SELECT PROV_TIN_NBR FROM OLE.DEBIT_FEE_ADJUSTMENT WHERE (DATE(ADJ_REQ_ON) = CURRENT_DATE OR DATE(ADJ_REQ_ON) = (CURRENT_DATE - 1 DAY)) AND ADJ_COMP_DTTM IS NULL AND FULL_ADJ_IND ='Y')\r\n" +
                 "GROUP BY DFA.PROV_TIN_NBR";
	     
	     public final static String ACTIVE_TIN = "SELECT ep.PROV_TIN_NBR as PROV_TAX_ID_NBR FROM ole.ENROLLED_PROVIDER ep WHERE ep.ENRL_STS_CD = 'A' AND ep.PAY_METH_TYP_CD = '{$tinType}'";
        
         public final static String UPDATED_DEBIT_FEE_ADJ="UPDATE OLE.DEBIT_FEE_ADJUSTMENT\r\n" + 
         		"         SET ADJ_REQ_ON = CURRENT DATE, TOTAL_FEE_INCURRED = '0.00'\r\n" + 
         		"         WHERE PROV_TIN_NBR = '{$tin}' AND FULL_ADJ_IND = 'Y' AND ADJ_COMP_DTTM IS NULL";

         public final static String ZERO_DEBIT_FEE="SELECT DFA.PROV_TIN_NBR AS PROV_TAX_ID_NBR \r\n" + 
         		"FROM OLE.DEBIT_FEE_ADJUSTMENT DFA\r\n" + 
         		"INNER JOIN OLE.ENROLLED_PROVIDER EP ON EP.PROV_TIN_NBR = DFA.PROV_TIN_NBR\r\n" + 
         		"INNER JOIN OLE.PRODUCT_SELECTION PS ON PS.PROV_TIN_NBR = EP.PROV_TIN_NBR\r\n" + 
         		"WHERE DFA.FULL_ADJ_IND = 'Y' AND DFA.ADJ_COMP_DTTM IS NULL "
         		//+ "AND DFA.TOTAL_FEE_INCURRED IN ('0.00') "
         		+ "AND EP.ENRL_STS_CD = 'A' AND EP.PAY_METH_TYP_CD = '{$tinType}'\r\n" + 
         		"AND PRTL_PRDCT_SELECTED_GRP_NM = '{$portalAccess}' AND PRTL_PRDCT_SELECTED_CD = 'P' AND PRTL_PRDCT_SELECTED_STS_CD = 'A'\r\n" + 
         		"fetch first row only";
         
         public final static String UPD_DEBIT_FEE_ADJ_NEG1="UPDATE OLE.DEBIT_FEE_ADJUSTMENT\r\n" + 
         		" 		 SET ADJ_REQ_ON = CURRENT DATE-2, TOTAL_FEE_INCURRED = '99.00'\r\n" + 
         		" 		WHERE PROV_TIN_NBR = '{$tin}' AND FULL_ADJ_IND = 'Y' AND ADJ_COMP_DTTM IS NULL ";
         
         
         public static final String NOTZERO_DEBIT_FEE =ZERO_DEBIT_FEE;
         
         public final static String BusinessPhone_ENROLLED_PROVIDER="SELECT BUSINESS_PHONE_EXT,BUSINESS_PHONE FROM ole.ENROLLED_PROVIDER ORDER BY LST_CHG_BY_DTTM DESC";
         public final static String TIN_NUMBER_ACCRUED_FEE_GRTR_THAN_0="SELECT dfi.PROV_TIN_NBR AS PROV_TAX_ID_NBR \r\n" +

 				"FROM\r\n" + 
 				"    ole.DEBIT_FEE_ACCRD dfi,\r\n" + 
 				"    OLE.ENROLLED_PROVIDER ep,\r\n" + 
 				"    OLE.PRODUCT_SELECTION ps \r\n" + 
 				"    WHERE dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR and dfi.PROV_TIN_NBR = ps.PROV_TIN_NBR    AND ps.PRTL_PRDCT_SELECTED_GRP_NM = 'Premium'    AND ps.PRTL_PRDCT_SELECTED_STS_CD = 'A'\r\n" + 
 				"    AND ep.ENRL_STS_CD = 'A'\r\n" + 
 				"    AND DBT_FEE_ACCRD_AMT > 0 \r\n" + 
 				"    ORDER BY dfi.PROC_DT DESC FETCH FIRST 1 ROWS ONLY  ";
 		
 		public final static String TIN_NUMBER_ACCRUED_FEE_LESS_THAN_EQUAL_0=" SELECT dfi.PROV_TIN_NBR AS PROV_TAX_ID_NBR \r\n" + 
 				"FROM\r\n" + 
 				"    ole.DEBIT_FEE_ACCRD dfi,\r\n" + 
 				"    OLE.ENROLLED_PROVIDER ep,\r\n" + 
 				"    OLE.PRODUCT_SELECTION ps \r\n" + 
 				"    WHERE dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR and dfi.PROV_TIN_NBR = ps.PROV_TIN_NBR    AND ps.PRTL_PRDCT_SELECTED_GRP_NM = 'Premium'    AND ps.PRTL_PRDCT_SELECTED_STS_CD = 'A'\r\n" + 
 				"    AND ep.ENRL_STS_CD = 'A'\r\n" + 
 				"    AND DBT_FEE_ACCRD_AMT <= 0\r\n" + 
 				"    ORDER BY dfi.PROC_DT DESC FETCH FIRST 1 ROWS ONLY";


	public static final String TINAboveZeroFee = "SELECT\n" +
			"\tdfi.PROV_TIN_NBR AS PROV_TAX_ID_NBR\n" +
			"FROM\n" +
			"\tole.DEBIT_FEE_ACCRD dfi,\n" +
			"\tOLE.ENROLLED_PROVIDER ep,\n" +
			"\tOLE.PRODUCT_SELECTION ps,\n" +
			"\tOLE.DEBIT_FEE_ADJUSTMENT dfa\n" +
			"\tWHERE dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR AND dfa.PROV_TIN_NBR = dfi.PROV_TIN_NBR and dfi.PROV_TIN_NBR = ps.PROV_TIN_NBR\tAND ps.PRTL_PRDCT_SELECTED_GRP_NM = 'Premium'\tAND ps.PRTL_PRDCT_SELECTED_STS_CD = 'A'\n" +
			"\tAND ep.ENRL_STS_CD = 'A'\n" +
			"\tAND ps.PRTL_PRDCT_REC_STS_CD ='PS'\n" +
			"\tAND dfi.DBT_FEE_ACCRD_AMT > 0 \n" +
			"\tAND ((DATE(ADJ_REQ_ON) != CURRENT_DATE OR DATE(ADJ_REQ_ON) != (CURRENT_DATE - 1 DAY)) \n" +
			"\tAND (ADJ_COMP_DTTM IS NOT NULL or FULL_ADJ_IND != 'Y' ))\n" +
			"\tAND SETL_DT  <= CURRENT_DATE\n" +
			"\tORDER BY dfi.PROC_DT DESC FETCH FIRST 1 ROWS ONLY WITH ur";


	public static final String TINEqualZeroFee_ProcessFeesInProgress = "SELECT\n" +
			"dfi.PROV_TIN_NBR AS PROV_TAX_ID_NBR\n" +
			"FROM\n" +
			"\tole.DEBIT_FEE_ACCRD dfi,\n" +
			"\tOLE.ENROLLED_PROVIDER ep,\n" +
			"\tOLE.PRODUCT_SELECTION ps,\n" +
			"\tOLE.DEBIT_FEE_ADJUSTMENT dfa\n" +
			"\tWHERE dfi.PROV_TIN_NBR = ep.PROV_TIN_NBR and dfi.PROV_TIN_NBR = ps.PROV_TIN_NBR\tAND ps.PRTL_PRDCT_SELECTED_GRP_NM = 'Premium'\tAND ps.PRTL_PRDCT_SELECTED_STS_CD = 'A'\n" +
			"\tAND ep.ENRL_STS_CD = 'A'\n" +
			"\tAND dfi.SETL_DT > CURRENT_DATE\n" +
			"\tAND dfi.DBT_FEE_ACCRD_AMT = 0 \n" +
			"\tAND ((DATE(ADJ_REQ_ON) != CURRENT_DATE OR DATE(ADJ_REQ_ON) != (CURRENT_DATE - 1 DAY)) \n" +
			"\tAND SUBSTRING(SETL_DT ,6,2) = SUBSTRING(CURRENT_DATE,6,2)\n" +
			"    OR (ADJ_COMP_DTTM IS NOT NULL or FULL_ADJ_IND != 'Y' ))\n" +
			"    AND ps.PRTL_PRDCT_REC_STS_CD ='PS'\n" +
			"\tORDER BY dfi.PROC_DT DESC FETCH FIRST 1 ROWS ONLY WITH ur";
	
	public static final String UPDATE_PROC_DATA="UPDATE OLE.SYSTEM_CONFIGURATION SET PROC_DATA = 'Y' WHERE proc_cd='ABA_API' and proc_tag_desc='CALL_ABA_API'";
	public final static String VAPY_TIN_835_EPRA_Visiblity="select A.CONSL_PAY_NBR, A.DSPL_CONSL_PAY_NBR , c.UCONSL_PAY_NBR, d.PAYR_KEY_ID,d.PRI_PAYR_ID,d.SEC_PAYR_ID,d.PAYR_NM,PAYR_TIN,A.PROV_KEY_ID,\r\n" + 
			"B.PROV_TAX_ID_NBR,b.PROV_NM,A.SETL_DT,A.CONSL_AMT,A.PAY_METH_CD, A.PROC_DTTM, a.PROC_CTL_ID,c.UCONSL_PROC_IND,c.UCONSL_CMPLN_IND,\r\n" + 
			"c.ORIG_BPR01_CD\r\n" + 
			"from pp063.consolidated_payment a, pp063.provider b, pp063.UNCONSOLIDATED_PAYMENT c,pp063.PAYOR d\r\n" + 
			"where a.prov_key_id = b.prov_key_id\r\n" + 
			"and c.consl_pay_nbr = a.CONSL_PAY_NBR\r\n" +
			"and a.PAYR_KEY_ID = d.PAYR_KEY_ID AND d.PRI_PAYR_ID  in (SELECT CONCAT ('1',SUB_PAYR_ID) AS PRI_PAYR_ID FROM OLE.SUB_PAYER p WHERE PAYR_835_ID='VPAY5' AND SUBPAYR_835_PRT_STS_OVR {$nullStat} AND SUBPAYR_EPRA_PRT_STS_OVR IS NULL)\r\n" +
			"order by CONSL_PAY_NBR desc\r\n"+
			"fetch first row only";
	public static final String WAIVE_FULL_AMOUNT = "Select PROV_TIN_NBR,sum(Total_DBT_Fee) as Total_Full_DBT_Fee from(\n"+
			"\tSelect PROV_TIN_NBR,Sum(DBT_FEE_ACCRD_AMT) as Total_DBT_Fee from OLE.DEBIT_FEE_ACCRD DFA\n"+ 
			"\tgroup by PROV_TIN_NBR,SETL_DT\n"+
			"\thaving SETL_DT Between CURRENT_DATE-(DAY(CURRENT_DATE)-1) and LAST_DAY(CURRENT_DATE)  and PROV_TIN_NBR = $ReplaceTINNumber$) as t group by PROV_TIN_NBR";


	public static final String WAIVE_PARTIAL_AMOUNT = "Select PROV_TIN_NBR,Sum(DBT_FEE_ACCRD_AMT) as Total_Partial_DBT_Fee from OLE.DEBIT_FEE_ACCRD DFA \n"+
	"\tgroup by PROV_TIN_NBR,SETL_DT \n"+
	"\thaving SETL_DT < CURRENT_DATE and SETL_DT >=CURRENT_DATE-(DAY(CURRENT_DATE)-1) and Sum(DBT_FEE_ACCRD_AMT)>0 and PROV_TIN_NBR in \n"+
	"\t(Select PROV_TIN_NBR from OLE.DEBIT_FEE_ACCRD DFA \n"+
	"\tgroup by PROV_TIN_NBR,SETL_DT \n"+
	"\thaving SETL_DT > CURRENT_DATE and SETL_DT <= LAST_DAY(CURRENT_DATE) and Sum(DBT_FEE_ACCRD_AMT)>0)";
	public static final String DBT_FEE_OTH_FEES = "WITH LSTFLDPYMT AS (SELECT * FROM OLE.DEBIT_FEE_OTH_FEES dfof WHERE dfof.CREAT_DTTM = (SELECT MAX(dfof2.CREAT_DTTM)\n"+
			"FROM OLE.DEBIT_FEE_OTH_FEES dfof2\n"+
			"WHERE dfof2.DBT_FEE_INVC_KEY_ID = dfof.DBT_FEE_INVC_KEY_ID)\n"+
			"ORDER BY CREAT_DTTM)\n"+
			"SELECT dfi.DBT_FEE_INVC_KEY_ID, dfi.BILL_CYC_STRT_DT, dfi.BILL_CYC_END_DT, dfi.INVC_TOT_AMT,dfi.BANK_ACCT_NBR, dfi.INVC_NBR,\n"+
			"cast(dfi.INVC_STS as VARCHAR(2)), dfi.PAID_DATE, dfi.PAID_BY_USER, dfi.CONFIRM_NBR, pu.FST_NM, pu.LST_NM, lst.RET_DT, lst.RET_REAS_DESC\n"+
			"FROM OLE.DEBIT_FEE_INVCE dfi\n"+
			"LEFT JOIN OLE.PORTAL_USER pu ON pu.PORTAL_USER_ID = dfi.PAID_BY_USER\n"+
			"LEFT JOIN LSTFLDPYMT lst ON dfi.DBT_FEE_INVC_KEY_ID = lst.DBT_FEE_INVC_KEY_ID AND dfi.PROV_TIN_NBR = lst.PROV_TIN_NBR\n"+
			"WHERE dfi.INVC_TYP = 'PPP' AND dfi.INVC_STS != 'IC' AND dfi.PROV_TIN_NBR = '{$tin}'\n"+
			"ORDER BY dfi.BILL_CYC_STRT_DT DESC, dfi.BILL_CYC_END_DT DESC FETCH FIRST 1 ROW ONLY WITH UR";
	
	public static final String PEP_TABLES_RECORDS_FOR_TIN = "SELECT pep.*,p.PAY_METH_OFR_CD FROM OLE.PAYER_ENROLLED_PROVIDER pep,OLE.PAYER p WHERE p.PAYR_835_ID =pep.PAYR_835_ID  \r\n" + 
			"AND p.PAYR_ACTV_IND ='Y' \r\n" + 
			"AND pep.PROV_TIN_NBR ='{$tin}' ";


	public static final String ORGINFO_IND="SELECT ORG_NAME_IND, BUSINESS_PHONE_IND , BUSINESS_ADDR_IND FROM OLE.ENROLLED_PROVIDER WHERE PROV_TIN_NBR ='{$tin}'";
	
	public static final String MFA_SWITCH_CHECK = "SELECT * FROM ole.SYSTEM_CONFIGURATION WHERE PROC_CD = 'MFA_SWITCH'";

		public static final String UNSECURE_GUEST_PAYMENT = "select \tdfi.PROV_TIN_NBR as PROV_TAX_ID_NBR, dfi.INVC_NBR FROM ole.DEBIT_FEE_INVCE dfi \n" +
			"where  dfi.INVC_STS in ('IR' , 'FP')\n" +
			"order by dfi.LST_CHG_BY_DTTM desc\n" +
			"fetch first row ONLY";

	public static final String PROVIDER_INFO="SELECT  * FROM ole.DEBIT_FEE_INVCE dfi WHERE  INVC_NBR ='{$invoiceNumber}'";
	
	public static final String AuthorizedINFO_IND="SELECT AUTH_ENROLLER_PHONE_IND FROM ole.CONTACT c WHERE PROV_TIN_NBR = '{$tin}' AND CNTC_ROLE_CD = 'E'";
	
	public static final String PROV_TIN_WITH_ACTIVE_USER = "SELECT put.prov_tin_nbr as PROV_TAX_ID_NBR, pu.fst_nm, pu.lst_nm \r\n" + 
			"			FROM ole.portal_user pu \r\n" + 
			"			INNER JOIN ole.portal_user_tin put ON pu.portal_user_id=put.portal_user_id\r\n" + 
			"			WHERE pu.STS_CD='A' and pu.USER_TYP='P'and put.PROV_TIN_NBR !=' ' ORDER BY LST_LOG_DTTM asc";
   public static final String  MOD_TYP_CD_PUHISTORY="SELECT  PUH.LST_CHG_BY_DTTM, PUH.LST_CHG_BY_ID, PUH.ACCESS_LVL, PUH.FST_NM ,PUH.LST_NM , PUH.USER_TYP,PUH.EMAIL_ADR_TXT,PUH.EMAIL_NTFY_IND,PUH.TEL_NBR,MT.MOD_TYP_DESC,PUH.MOD_TYP_CD\r\n" + 
   		"      FROM OLE.PORTAL_USER_HISTORY PUH\r\n" + 
   		"   LEFT JOIN OLE.MOD_TYP MT ON PUH.MOD_TYP_CD = MT.MOD_TYP_CD\r\n" + 
   		"   WHERE PROV_TIN_NBR ='{$tin}'\r\n" + 
   		"   order by lst_chg_by_dttm desc  FETCH FIRST 1 ROW ONLY";
   public static final String GET_LAST_UPDATED_DATE="SELECT PROV_TIN_NBR ,LST_CHG_BY_DTTM FROM ole.PORTAL_USER_HISTORY puh2 WHERE STS_CD ='FD' ORDER BY LST_CHG_BY_DTTM DESC FETCH FIRST ROW ONLY";
   
   public static final String TIN_WITHOUT_RECURR_PAY= "select ps.PROV_TIN_NBR as PROV_TAX_ID_NBR from ole.product_selection ps \r\n" + 
   		"where ps.PRTL_PRDCT_SELECTED_GRP_NM='{$portalAccess}' and ps.PRTL_PRDCT_REC_STS_CD='PS' and ps.PRTL_PRDCT_SELECTED_STS_CD='A'\r\n" + 
   		"AND ps.PROV_TIN_NBR NOT in (\r\n" + 
   		"\r\n" + 
   		"SELECT  paba.PROV_TIN_NBR  FROM ole.PAYMENT_DESIGNATION pd\r\n" + 
   		"LEFT JOIN ole.PROV_ALTERNATE_BANKING_ACCOUNT paba ON paba.PROV_ALT_BNK_ACCT_ID = pd.PROV_ALT_BNK_ACCT_ID\r\n" + 
   		"LEFT JOIN ole.ENROLLED_PROVIDER ep  ON paba.PROV_TIN_NBR = ep.PROV_TIN_NBR\r\n" + 
   		"WHERE  pd.PAY_DESG_ACTV_IND = 'Y' AND RECR_PAY_SET_IND = 'Y' AND  paba.PROV_TIN_NBR IS NOT null\r\n" + 
   		"and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A'\r\n" + 
   		"UNION\r\n" + 
   		"SELECT  pba.PROV_TIN_NBR  FROM ole.PAYMENT_DESIGNATION pd \r\n" + 
   		"LEFT JOIN ole.PROVIDER_BANKING_ACCOUNT pba ON pba.PROV_BNK_ACCT_ID = pd.PROV_BNK_ACCT_ID\r\n" + 
   		"LEFT JOIN ole.ENROLLED_PROVIDER ep  ON pba.PROV_TIN_NBR = ep.PROV_TIN_NBR\r\n" + 
   		"WHERE  pd.PAY_DESG_ACTV_IND = 'Y' AND RECR_PAY_SET_IND = 'Y' AND pba.PROV_TIN_NBR IS NOT null\r\n" + 
   		"and ep.PAY_METH_TYP_CD='{$tinType}' and ep.ENRL_STS_CD='A' ) with ur fetch first row only";

	public static String TIN = System.getProperty("tin");
	public static final String readPrimarnyBankAccountLog ="SELECT pd.LST_CHG_BY_ID, pd.LST_CHG_BY_DTTM, pba.PROV_TIN_NBR , pd.RECR_PAY_SET_IND , pd.LST_CHG_BY_DTTM, pd.LST_CHG_BY_PRTL_ID FROM ole.PAYMENT_DESIGNATION pd LEFT JOIN ole.PROVIDER_BANKING_ACCOUNT pba ON pba.PROV_BNK_ACCT_ID = pd.PROV_BNK_ACCT_ID\n" +
			"WHERE pba.PROV_TIN_NBR = '"+TIN+"' AND pd.PAY_DESG_ACTV_IND = 'Y' AND RECR_PAY_SET_IND = 'Y'ORDER BY pd.LST_CHG_BY_DTTM  DESC with ur";
	public static final String readPaymentDesignationHistoryFortheTIN = "SELECT * FROM ole.PAYMENT_DESIGNATION_HISTORY pdh WHERE PROV_TIN_NBR  ='"+TIN+"' ORDER BY pdh.LST_CHG_BY_DTTM DESC WITH ur";
	public static final String readAlternateBankAccountLog ="SELECT pd.LST_CHG_BY_ID, pd.LST_CHG_BY_DTTM,PAYR_TIN_NBR , pd.RECR_PAY_SET_IND , pd.LST_CHG_BY_PRTL_ID  FROM ole.PAYMENT_DESIGNATION pd\n" +
			"LEFT JOIN ole.PROV_ALTERNATE_BANKING_ACCOUNT paba ON paba.PROV_ALT_BNK_ACCT_ID = pd.PROV_ALT_BNK_ACCT_ID\n" +
			"WHERE paba.PROV_TIN_NBR = '"+TIN+"' AND pd.PAY_DESG_ACTV_IND = 'Y' AND RECR_PAY_SET_IND = 'Y' ORDER BY pd.LST_CHG_BY_DTTM DESC with ur";
}


