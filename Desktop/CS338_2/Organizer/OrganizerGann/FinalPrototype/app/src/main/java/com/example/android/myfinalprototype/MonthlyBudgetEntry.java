package com.example.android.myfinalprototype;

/**
 * This is the base model for an entry of Monthly Budget items. It has getters for each
 * value so they can later be accessed by other classes.
 * Created by Kaitlin on 2/13/2018.
 */

public class MonthlyBudgetEntry {

    private long id;
    private String incomeAmt1;
    private String incomeAmt2;
    private String incomeName1;
    private String incomeName2;
    private String fixedAmt1;
    private String fixedAmt2;
    private String fixedAmt3;
    private String fixedAmt4;
    private String fixedAmt5;
    private String fixedAmt6;
    private String fixedAmt7;
    private String fixedName1;
    private String fixedName2;
    private String fixedName3;
    private String fixedName4;
    private String fixedName5;
    private String fixedName6;
    private String fixedName7;
    private String variableAmt1;
    private String variableAmt2;
    private String variableAmt3;
    private String variableAmt4;
    private String variableAmt5;
    private String variableAmt6;
    private String variableAmt7;
    private String variableName1;
    private String variableName2;
    private String variableName3;
    private String variableName4;
    private String variableName5;
    private String variableName6;
    private String variableName7;


    /**
     * Constructor
     * This method initializes the values above to the values being passed in.
     * @param incomeAmt1 - The first income amount
     * @param incomeAmt2 - The second income amount
     * @param incomeName1 - The name of the first income
     * @param incomeName2 - The name of the second income
     * @param fixedAmt1 - The first fixed expense amount
     * @param fixedAmt2 - The second fixed expense amount
     * @param fixedAmt3 - The third fixed expense amount
     * @param fixedAmt4 - The fourth fixed expense amount
     * @param fixedAmt5 - The fifth fixed expense amount
     * @param fixedAmt6 - The sixth fixed expense amount
     * @param fixedAmt7 - The seventh fixed expense amount
     * @param fixedName1 - The name of the first fixed expense
     * @param fixedName2 - The name of the second fixed expense
     * @param fixedName3 - The name of the third fixed expense
     * @param fixedName4 - The name of the fourth fixed expense
     * @param fixedName5 - The name of the fifth fixed expense
     * @param fixedName6 - The name of the sixth fixed expense
     * @param fixedName7 - The name of the seventh fixed expense
     * @param variableAmt1 - The first variable expense amount
     * @param variableAmt2 - The second variable expense amount
     * @param variableAmt3 - The third variable expense amount
     * @param variableAmt4 - The fourth variable expense amount
     * @param variableAmt5 - The fifth variable expense amount
     * @param variableAmt6 - The sixth variable expense amount
     * @param variableAmt7 - The seventh variable expense amount
     * @param variableName1 - The name of the first variable expense
     * @param variableName2 - The name of the second variable expense
     * @param variableName3 - The name of the third variable expense
     * @param variableName4 - The name of the fourth variable expense
     * @param variableName5 - The name of the fifth variable expense
     * @param variableName6 - The name of the sixth variable expense
     * @param variableName7 - The name of the seventh variable expense
     */
    public MonthlyBudgetEntry(String incomeAmt1, String incomeAmt2, String incomeName1,
                              String incomeName2, String fixedAmt1, String fixedAmt2, String fixedAmt3,
                              String fixedAmt4, String fixedAmt5, String fixedAmt6, String fixedAmt7,
                              String fixedName1, String fixedName2, String fixedName3,
                              String fixedName4, String fixedName5, String fixedName6,
                              String fixedName7, String variableAmt1, String variableAmt2,
                              String variableAmt3, String variableAmt4, String variableAmt5,
                              String variableAmt6, String variableAmt7, String variableName1,
                              String variableName2, String variableName3, String variableName4,
                              String variableName5, String variableName6, String variableName7) {
        this.incomeAmt1 = incomeAmt1;
        this.incomeAmt2 = incomeAmt2;
        this.incomeName1 = incomeName1;
        this.incomeName2 = incomeName2;
        this.fixedAmt1 = fixedAmt1;
        this.fixedAmt2 = fixedAmt2;
        this.fixedAmt3 = fixedAmt3;
        this.fixedAmt4 = fixedAmt4;
        this.fixedAmt5 = fixedAmt5;
        this.fixedAmt6 = fixedAmt6;
        this.fixedAmt7 = fixedAmt7;
        this.fixedName1 = fixedName1;
        this.fixedName2 = fixedName2;
        this.fixedName3 = fixedName3;
        this.fixedName4 = fixedName4;
        this.fixedName5 = fixedName5;
        this.fixedName6 = fixedName6;
        this.fixedName7 = fixedName7;
        this.variableAmt1 = variableAmt1;
        this.variableAmt2 = variableAmt2;
        this.variableAmt3 = variableAmt3;
        this.variableAmt4 = variableAmt4;
        this.variableAmt5 = variableAmt5;
        this.variableAmt6 = variableAmt6;
        this.variableAmt7 = variableAmt7;
        this.variableName1 = variableName1;
        this.variableName2 = variableName2;
        this.variableName3 = variableName3;
        this.variableName4 = variableName4;
        this.variableName5 = variableName5;
        this.variableName6 = variableName6;
        this.variableName7 = variableName7;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIncomeAmt1() {
        return incomeAmt1;
    }

    public String getIncomeAmt2() {
        return incomeAmt2;
    }

    public String getIncomeName1() {
        return incomeName1;
    }

    public String getIncomeName2() {
        return incomeName2;
    }

    public String getFixedAmt1() {
        return fixedAmt1;
    }

    public String getFixedAmt2() {
        return fixedAmt2;
    }

    public String getFixedAmt3() {
        return fixedAmt3;
    }

    public String getFixedAmt4() {
        return fixedAmt4;
    }

    public String getFixedAmt5() {
        return fixedAmt5;
    }

    public String getFixedAmt6() {
        return fixedAmt6;
    }

    public String getFixedAmt7() {
        return fixedAmt7;
    }

    public String getFixedName1() {
        return fixedName1;
    }

    public String getFixedName2() {
        return fixedName2;
    }

    public String getFixedName3() {
        return fixedName3;
    }

    public String getFixedName4() {
        return fixedName4;
    }

    public String getFixedName5() {
        return fixedName5;
    }

    public String getFixedName6() {
        return fixedName6;
    }

    public String getFixedName7() {
        return fixedName7;
    }

    public String getVariableAmt1() {
        return variableAmt1;
    }

    public String getVariableAmt2() {
        return variableAmt2;
    }

    public String getVariableAmt3() {
        return variableAmt3;
    }

    public String getVariableAmt4() {
        return variableAmt4;
    }

    public String getVariableAmt5() {
        return variableAmt5;
    }

    public String getVariableAmt6() {
        return variableAmt6;
    }

    public String getVariableAmt7() {
        return variableAmt7;
    }

    public String getVariableName1() {
        return variableName1;
    }

    public String getVariableName2() {
        return variableName2;
    }

    public String getVariableName3() {
        return variableName3;
    }

    public String getVariableName4() {
        return variableName4;
    }

    public String getVariableName5() {
        return variableName5;
    }

    public String getVariableName6() {
        return variableName6;
    }

    public String getVariableName7() {
        return variableName7;
    }
}

