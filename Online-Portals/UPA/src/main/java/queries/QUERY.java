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
}
