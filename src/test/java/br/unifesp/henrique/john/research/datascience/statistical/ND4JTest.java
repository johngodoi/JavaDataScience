//package br.unifesp.henrique.john.research.datascience.statistical;
//
//import br.unifesp.henrique.john.research.datascience.utils.ConstantValues;
//import org.junit.Test;
//import org.nd4j.linalg.api.ndarray.INDArray;
//import org.nd4j.linalg.dimensionalityreduction.PCA;
//import org.nd4j.linalg.factory.Nd4j;
//import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by john on 26/06/16.
// */
//public class ND4JTest {
//    @Test
//    public void criarMatrix() throws Exception {
//        INDArray arr1 = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{2, 2});
//        System.out.println(arr1);
//        // [[1,00, 2,00],
//        // [3,00, 4,00]]
//        assertEquals("Acessando posição linha 0 e coluna 0", 1., arr1.getDouble(0, 0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 0 e coluna 1", 2., arr1.getDouble(0, 1), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 0", 3., arr1.getDouble(1, 0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 1", 4., arr1.getDouble(1, 1), ConstantValues.precision);
//
//        arr1.addi(1);
//        System.out.println(arr1);
//        // [[2,00, 3,00],
//        // [4,00, 5,00]]
//        assertEquals("Acessando posição linha 0 e coluna 0", 2., arr1.getDouble(0, 0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 0 e coluna 1", 3., arr1.getDouble(0, 1), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 0", 4., arr1.getDouble(1, 0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 1", 5., arr1.getDouble(1, 1), ConstantValues.precision);
//
//        INDArray arr2 = Nd4j.create(new float[]{5, 6, 7, 8}, new int[]{2, 2});
//        arr1.addi(arr2);
//        System.out.println(arr1);
//        // [[ 7,00,  9,00],
//        // [11,00, 13,00]]
//        assertEquals("Acessando posição linha 0 e coluna 0", 7., arr1.getDouble(0, 0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 0 e coluna 1", 9., arr1.getDouble(0, 1), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 0", 11., arr1.getDouble(1, 0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 1", 13., arr1.getDouble(1, 1), ConstantValues.precision);
//
//        INDArray row0 = arr1.getRow(0);
//        System.out.println(row0);
//        // [7,00, 9,00]
//        assertEquals("Acessando posição linha 0 e coluna 0", 7., row0.getDouble(0), ConstantValues.precision);
//        assertEquals("Acessando posição linha 0 e coluna 1", 9., row0.getDouble(1), ConstantValues.precision);
//
//        INDArray column1 = arr1.getColumn(1);
//        System.out.println(column1);
//        // [ 9,00, 13,00]
//        assertEquals("Acessando posição linha 0 e coluna 1", 9., arr1.getDouble(0, 1), ConstantValues.precision);
//        assertEquals("Acessando posição linha 1 e coluna 1", 13., arr1.getDouble(1, 1), ConstantValues.precision);
//
//    }
//
//    @Test
//    public void multiplicaoDeMatrizes() {
//
//        INDArray arr1 = Nd4j.create(new float[]{1, 2, 3, 4}, new int[]{2, 2});
//        System.out.println(arr1);
//
//        INDArray arr2 = Nd4j.create(new float[]{5, 6, 7, 8}, new int[]{2, 2});
//        arr1.addi(arr2);
//
//        INDArray mulArray = arr1.mul(arr2);
//        System.out.println(mulArray);
//        // [[ 35,00,  54,00],
//        // [ 77,00, 104,00]]
//    }
//
//    @Test
//    public void statisticalManipulation() {
//        INDArray arr1 = Nd4j.create(new float[]{2, 3, 4, 5}, new int[]{2, 2});
//        System.out.println(arr1);
//
//        INDArray arr2 = Nd4j.create(new float[]{5, 6, 7, 8}, new int[]{2, 2});
//        arr1.addi(arr2);
//
//        assertEquals("Média da matriz",10.,arr1.meanNumber());
//        assertEquals("Variância da matriz",6.66666,arr1.varNumber().doubleValue(), ConstantValues.precision);
//        assertEquals("Desvio padrão da matriz",2.58199,arr1.stdNumber().doubleValue(), ConstantValues.precision);
//    }
//
//    @Test
//    public void pca(){
//        INDArray arr1 = Nd4j.create(new float[]{2, 3, 4, 5, 6, 7, 8, 9});
//
//        INDArray pca = PCA.pca(arr1, 1, true);
//        System.out.println(pca);
//
//    }
//}
