class BalancoTrimestral {
    public static void main (String[] args){
        int gastos_jan = 15000;
        int gastos_fev = 23000;
        int gastos_marc = 17000;

        int gastos_trimestre = gastos_jan + gastos_fev + gastos_marc;
        System.out.println("Gastos do trimestre: " + gastos_trimestre);
        System.out.println("\n");
        double media = gastos_trimestre / 3;
        System.out.println("media de gastos: " + media);
        
        
    }
}