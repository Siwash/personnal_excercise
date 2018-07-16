package rpf.test;


public class Test {  
    public static void main(String [] args){  
        //System.out.println(new B().getValue());
    	for(int i=4;i>0;i--) {
    		int j=0;
    		do {
				j++;
				if (j==2) {
					break;
				}
			} while (j>i);
    		System.out.println(j);
    	}
    }  
    static class A{ 
    	
        protected int value;  
        public A(int v) {
            setValue(v);  
        }  
        public void setValue(int value){  
            this.value = value;  
        }  
        public int getValue(){  
            try{  
                value++;  
                return value;  
            } catch(Exception e){  
                System.out.println(e.toString());  
            } finally {  
                this.setValue(value);  
                System.out.println("finally:"+value);  
            }  
            return value;  
        }  
    }  
    static class B extends A{  
        public B() {  
            super(5);
            int v=getValue() - 3;
            System.out.println("V :"+v);
            setValue(v);  
        }  
        public void setValue(int value){
        	System.out.println("value:"+value);
            super.setValue(2 * value);  
        }  
    }  
}  
