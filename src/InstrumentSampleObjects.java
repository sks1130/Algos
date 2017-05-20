import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * 
 */

/**
 * @author sachin
 *
 */
import static java.lang.System.out;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.jar.JarFile;

/**
 * Build up some sample objects and throw them at the Instrumentation example.
 * 
 * Might run this class as shown next:
 * java -javaagent:dist\agent.jar -cp dist\agent.jar dustin.examples.InstrumentSampleObjects 
 * 
 * @author Dustin
 */
public class InstrumentSampleObjects implements Instrumentation
{
   public enum Color
   {
      RED,
      WHITE,
      YELLOW
   }

   /**
    * Print basic details including size of provided object to standard output.
    * 
    * @param object Object whose value and size are to be printed to standard
    *   output.
    */
   public static void printInstrumentationSize(final Object object)
   {
      out.println(
           "Object of type '" + object.getClass() + "' has size of "
         + InstrumentationAgent.getObjectSize(object) + " bytes.");
   }

   /**
    * Main executable function.
    * 
    * @param arguments Command-line arguments; none expected.
    */
   public static void main(final String[] arguments)
   {
      final StringBuilder sb = new StringBuilder(1000);
      final boolean falseBoolean = false;
      final int zeroInt = 0;
      final double zeroDouble = 0.0;
      final Long zeroLong = 0L;
      final long zeroLongP = 0L;
      final Long maxLong = Long.MAX_VALUE;
      final Long minLong = Long.MIN_VALUE;
      final long maxLongP = Long.MAX_VALUE;
      final long minLongP = Long.MIN_VALUE;
      final String emptyString = "";
      final String string = "ToBeOrNotToBeThatIsTheQuestion";
      final String[] strings = {emptyString, string, "Dustin"};
      final String[] moreStrings = new String[1000];
      final List<String> someStrings = new ArrayList<String>();
      final BigDecimal bd = new BigDecimal("999999999999999999.99999999");
      final Calendar calendar = Calendar.getInstance();

   }

@Override
public void addTransformer(ClassFileTransformer transformer, boolean canRetransform) {
	// TODO Auto-generated method stub
	
}

@Override
public void addTransformer(ClassFileTransformer transformer) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean removeTransformer(ClassFileTransformer transformer) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isRetransformClassesSupported() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void retransformClasses(Class<?>... classes) throws UnmodifiableClassException {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isRedefineClassesSupported() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void redefineClasses(ClassDefinition... definitions) throws ClassNotFoundException, UnmodifiableClassException {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isModifiableClass(Class<?> theClass) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Class[] getAllLoadedClasses() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Class[] getInitiatedClasses(ClassLoader loader) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public long getObjectSize(Object objectToSize) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public void appendToBootstrapClassLoaderSearch(JarFile jarfile) {
	// TODO Auto-generated method stub
	
}

@Override
public void appendToSystemClassLoaderSearch(JarFile jarfile) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean isNativeMethodPrefixSupported() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void setNativeMethodPrefix(ClassFileTransformer transformer, String prefix) {
	// TODO Auto-generated method stub
	
}
}

