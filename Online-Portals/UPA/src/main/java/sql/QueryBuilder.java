package main.java.sql;

import main.java.nativeFunctions.TestBase;

public class QueryBuilder {
    TestBase testConfig=TestBase.getInstance();

    public String getFeeSearchQuery(String param) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT  DBT_FEE_KEY_ID, PAYMENT_DATE, PAYER_NAME, SUBPAYER_NAME, CONSL_PAY_NBR, CONSL_AMT, INVC_NBR, INVC_SETL_DT, RET_REAS_CD, FEE_STATUS, PROV_TIN_NBR, ROW_TYPE, DBT_FEE_ACCRD_AMT\n" +
                "FROM (\n" +
                "    SELECT \n" +
                "        dfa.DBT_FEE_KEY_ID,\n" +
                "        dfa.SETL_DT AS PAYMENT_DATE,\n" +
                "        (select p.PAYR_DSPL_NM from OLE.PAYER p where SUBSTR(dfa.PRI_PAYR_ID, 2, LENGTH(dfa.PRI_PAYR_ID) - 1) = p.PAYR_TIN_NBR AND dfa.SEC_PAYR_ID = p.PAYR_835_ID LIMIT 1) PAYER_NAME,\n" +
                "        (select DISTINCT s.SUB_PAYR_DSPL_NM from ole.SUB_PAYER s where SUBSTR(dfa.PRI_PAYR_ID, 2, LENGTH(dfa.PRI_PAYR_ID) - 1) = s.SUB_PAYR_ID AND dfa.SEC_PAYR_ID = s.PAYR_835_ID) SUBPAYER_NAME,\n" +
                "        dfa.CONSL_PAY_NBR,\n" +
                "        dfa.CONSL_AMT,\n" +
                "        dfa.DBT_FEE_ACCRD_AMT, \n" +
                "        dfi.INVC_NBR, \n" +
                "        dfi.INVC_SETL_DT,\n" +
                "        dfof.RET_REAS_CD,\n" +
                "        dfa.DBT_FEE_ACCRD_STS AS FEE_STATUS,\n" +
                "        dfa.PROV_TIN_NBR,\n" +
                "        'ACCRD' AS ROW_TYPE\n" +
                "    FROM OLE.DEBIT_FEE_ACCRD dfa\n" +
                "    LEFT JOIN OLE.DEBIT_FEE_INVCE_DTL dfid ON dfa.DBT_FEE_INVC_DTL_KEY_ID = dfid.DBT_FEE_INVC_DTL_KEY_ID\n" +
                "    LEFT JOIN ole.DEBIT_FEE_INVCE dfi ON dfi.DBT_FEE_INVC_KEY_ID = dfid.DBT_FEE_INVC_KEY_ID\n" +
                "    LEFT JOIN ole.DEBIT_FEE_OTH_FEES dfof ON dfof.DBT_FEE_INVC_KEY_ID = dfi.DBT_FEE_INVC_KEY_ID\n" +
                "    UNION\n" +
                "    \n" +
                "    SELECT \n" +
                "        dfr.DBT_FEE_KEY_ID,\n" +
                "        dfa2.SETL_DT AS PAYMENT_DATE,\n" +
                "        (select p.PAYR_DSPL_NM from OLE.PAYER p where dfa2.PRI_PAYR_ID = p.PAYR_TIN_NBR AND dfa2.SEC_PAYR_ID = p.PAYR_835_ID) PAYER_NAME,\n" +
                "        (select DISTINCT s.SUB_PAYR_DSPL_NM from ole.SUB_PAYER s where dfa2.PRI_PAYR_ID = s.SUB_PAYR_ID AND dfa2.SEC_PAYR_ID = s.PAYR_835_ID) SUBPAYER_NAME,\n" +
                "        dfr.CONSL_PAY_NBR,\n" +
                "        dfr.CONSL_AMT,\n" +
                "        dfr.DBT_FEE_ACCRD_AMT, \n" +
                "        NULL AS INVC_NBR,\n" +
                "        NULL AS INVC_SETL_DT,\n" +
                "        NULL AS RET_REAS_CD,\n" +
                "        dfr.DBT_FEE_RFND_STS AS FEE_STATUS,\n" +
                "        dfr.PROV_TIN_NBR,\n" +
                "        'RFD' AS ROW_TYPE\n" +
                "    FROM OLE.DEBIT_FEE_REFUND dfr\n" +
                "    LEFT JOIN OLE.DEBIT_FEE_ACCRD dfa2 ON dfa2.DBT_FEE_KEY_ID = dfr.DBT_FEE_KEY_ID \n" +
                ") combined\n" +
                "WHERE PROV_TIN_NBR = '");
        query.append(testConfig.getRunTimeProperty("tin"));
        query.append("'");


        if(param.equals("feeSearchPaymentNumber")){
            query.append(" AND CONSL_PAY_NBR in (select consl_pay_nbr from ole.DEBIT_FEE_ACCRD where  dspl_consl_pay_nbr = '");
            query.append(testConfig.getRunTimeProperty("paymentNumber"));
            query.append("')");
        }

        if(param.equals("feeSearchInvoiceNumber")){
            query.append(" AND AND INVC_NBR = '");
            query.append(testConfig.getRunTimeProperty("invoiceNumber"));
            query.append("'");
        }

        query.append(" ORDER by PAYMENT_DATE DESC, CONSL_PAY_NBR ASC, DBT_FEE_KEY_ID ASC, ROW_TYPE");
        return query.toString();
    }


}