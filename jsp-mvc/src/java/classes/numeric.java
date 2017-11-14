/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author o.kesmez
 */
public class numeric {
    public String string = "";
    public int integer   = 0;
    public double doubleNumber = 0;
    public float floatNumber   = 0;
    
    public void setString(String string){
        this.string = string;
    }
    
    public void setInt(int integer){
        this.integer = integer;
    }
    
    public void setDouble(double doubleNumber){
        this.doubleNumber = doubleNumber;
    }
    
    public void setFloat(float floatNumber){
        this.floatNumber = floatNumber;
    }
    
    /*Numerik Fonksiyonları Başlangıcı*/
    
    /*
    * Tanımlaması yapılmış olan float , int ya da double türündeki iki numerik ifade için kotrol sağlar.
    * Kullanım int : setInt(12) şeklinde int değerimiz tanımlanır, ardından type değeri 1 olacak şekilde getCompareTo(1,10); ile fonksiyon çalıştırılır. 12 sayısı ile 10 sayısını karşılaştırır.
    * Kullanım double : setDouble(12,2) şeklinde double değerimiz tanımlanır, ardından type değeri 2 olacak şekilde getCompareTo(2,10); ile fonksiyon çalıştırılır.
    * Kullanım float  : setFloat(12,3f) şeklinde float değerimiz tanımlanır, ardından type değeri 3 olacak şekilde getCompareTo(3,10); ile fonksiyon çalıştırılır.
    * Sonuç Yorumla   : integer türünde 0 döner ise sayılar eşit, eğer -1 ise getCompareTo(1,10) ile gönderilen değer sisteme tanımlanandan büyük  , 
    * Sonuç Yorumla - 2 :eğer 1 ise getCompareTo(1,10) ile gönderilen değer sisteme tanımlanandan küçüktür.  
    * UYARI : Bu fonksiyon ile int değer int değer ile , double değer double değer ile ,float değer float değer ile karşılaştırılabilir.
    */
    public int getCompareTo(int type, Object number){
        int result = 0;
        if(type==1){
            result = ((Integer) integer).compareTo((Integer) number) ; 
        }else if(type==2){
            result = ((Double) doubleNumber).compareTo((Double) number) ;
        }else if(type==3){
            result = ((Float) floatNumber).compareTo((Float) number) ;
        }
        
        return result;
    }
    
    /*
    * string türünde gönderilen değerleri valueOf methodunu kullanarak istediğimiz tür çevirdik.
    * getIntValueOf(String value) => integer türüne çevirir.
    * getDoubleValueOf(String value)=> double türüne çevirir.
    * getFloatValueOf(String value) => float türüne çevirir.
    * Önemli : valueOf fonksiyonu tüm tiplerdeki değişkenleri istenilen tipe dönüştürür. toDouble,toInteger... vb. methodlar sadece string türleri değiştirir
    */
    public int getIntValueOf(int type,String value){
        if(type==1){
            integer = Integer.valueOf(value);
        } else{
            integer = Integer.parseInt(value);
        }
        return integer;
    }
    
    public double getDoubleValueOf(Object value){
        doubleNumber = Double.valueOf((Double)value);
        return doubleNumber;
    }
    
    public double getFloatValueOf(Object value){
        floatNumber = Float.valueOf((Float)value);
        return floatNumber;
    }
    
    
    
}
