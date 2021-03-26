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
			"AND PC.EXTRACT_STS_CD = 'C'\r\n"+QUERY.ENDQUERY;
		
		public final static String ENDQUERY="group by p.prov_tax_id_nbr,cp.DSPL_CONSL_PAY_NBR,cp.CONSL_PAY_NBR, cp.setl_dt\r\n"+
			"having count(*) between 1 and 30\r\n"+
			"order by count(*) desc\r\n"+
			"fetch first row only";
			
		public final static String ZERODOLLAR= QUERY.PAYMENT_TIN + "and cp.PAY_AMNT='0' "+QUERY.ENDQUERY;

		public final static String PAYER_LIST="WITH result AS ( select  PAYR_DSPL_NM, PAYR_TIN_NBR,SORT_ORDER from OLE.PAYER p\r\n" + 
				" where PAYR_TIN_NBR in (select PAYR_TIN_NBR  from OLE.PAYER_ENROLLED_PROVIDER  where PROV_TIN_NBR= '383612247' ) \r\n" + 
				" and {fn TIMESTAMPDIFF( SQL_TSI_MONTH, CURRENT TIMESTAMP,LST_CHG_BY_DTTM)} <= 13 and PAYR_ACTV_IND='N'\r\n" + 
				" union \r\n" + 
				" Select PAYR_DSPL_NM, PAYR_TIN_NBR,SORT_ORDER  from OLE.PAYER  where PAYR_TIN_NBR in  \r\n" + 
				" (select PAYR_TIN_NBR from OLE.PAYER_ENROLLED_PROVIDER where PROV_TIN_NBR= '383612247' )  \r\n" + 
				" AND NOT PAYR_DSPL_NM='US Dept of Health and Human Services' and PAYR_ACTV_IND='Y' ORDER BY SORT_ORDER ASC , PAYR_DSPL_NM)\r\n" + 
				"SELECT\r\n" + 
				"    *,\r\n" + 
				"    (SELECT COUNT(*) FROM result) AS TotalRows\r\n" + 
				"FROM result";
}
