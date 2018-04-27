package com.example.android.myfinalprototype;

import android.provider.BaseColumns;

/**
 * These classes serve as a contract for the MonthlyBudgetActivity and the Database.
 * Created by Kaitlin on 2/20/2018.
 */

public class MonthlyBudgetContract {

    public static abstract class BudgetEntry implements BaseColumns {

        public static final String BUDGET_TABLE = "monthly_budget";
        public static final String ID_FIELD  = "_id";
        public static final String AMT_INCOME1 = "incomeAmt1";
        public static final String AMT_INCOME2 = "incomeAmt2";
        public static final String NAME_INCOME1 = "incomeName1";
        public static final String NAME_INCOME2 = "incomeName2";
        public static final String AMT_FIXED1 = "fixedAmt1";
        public static final String AMT_FIXED2 = "fixedAmt2";
        public static final String AMT_FIXED3 = "fixedAmt3";
        public static final String AMT_FIXED4 = "fixedAmt4";
        public static final String AMT_FIXED5 = "fixedAmt5";
        public static final String AMT_FIXED6 = "fixedAmt6";
        public static final String AMT_FIXED7 = "fixedAmt7";
        public static final String NAME_FIXED1 = "fixedName1";
        public static final String NAME_FIXED2 = "fixedName2";
        public static final String NAME_FIXED3 = "fixedName3";
        public static final String NAME_FIXED4 = "fixedName4";
        public static final String NAME_FIXED5 = "fixedName5";
        public static final String NAME_FIXED6 = "fixedName6";
        public static final String NAME_FIXED7 = "fixedName7";
        public static final String AMT_VARIABLE1 = "variableAmt1";
        public static final String AMT_VARIABLE2 = "variableAmt2";
        public static final String AMT_VARIABLE3 = "variableAmt3";
        public static final String AMT_VARIABLE4 = "variableAmt4";
        public static final String AMT_VARIABLE5 = "variableAmt5";
        public static final String AMT_VARIABLE6 = "variableAmt6";
        public static final String AMT_VARIABLE7 = "variableAmt7";
        public static final String NAME_VARIABLE1 = "variableName1";
        public static final String NAME_VARIABLE2 = "variableName2";
        public static final String NAME_VARIABLE3 = "variableName3";
        public static final String NAME_VARIABLE4 = "variableName4";
        public static final String NAME_VARIABLE5 = "variableName5";
        public static final String NAME_VARIABLE6 = "variableName6";
        public static final String NAME_VARIABLE7 = "variableName7";

    }
}
