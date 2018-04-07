// For conditions of distribution and use, see copyright notice in Morphognosis.java

// Utility class.

package morphognosis;

import java.io.*;

public abstract class Utility
{
   // Load integer.
   public static int loadInt(DataInputStream in) throws IOException
   {
      return(in.readInt());
   }


   // Load float.
   public static float loadFloat(DataInputStream in) throws IOException
   {
      return(in.readFloat());
   }


   // Load double.
   public static double loadDouble(DataInputStream in) throws IOException
   {
      return(in.readDouble());
   }


   // Save integer.
   public static void saveInt(DataOutputStream out, int value) throws IOException
   {
      out.writeInt(value);
   }


   // Save float.
   public static void saveFloat(DataOutputStream out, float value) throws IOException
   {
      out.writeFloat(value);
   }


   // Save double.
   public static void saveDouble(DataOutputStream out, double value) throws IOException
   {
      out.writeDouble(value);
   }


   // Prevent instantiation.
   private Utility() {}
}
