// For conditions of distribution and use, see copyright notice in Morphognosis.java

package morphognosis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Metamorph.
public class Metamorph
{
   // Morphognostic.
   public Morphognostic morphognostic;

   // Response.
   public int    response;
   public String responseName;

   // Constructors.
   public Metamorph(Morphognostic morphognostic, int response)
   {
      this.morphognostic = morphognostic;
      this.response      = response;
      responseName       = "";
   }


   public Metamorph(Morphognostic morphognostic, int response, String responseName)
   {
      this.morphognostic = morphognostic;
      this.response      = response;
      this.responseName  = responseName;
   }


   // Equality test.
   public boolean equals(Metamorph m)
   {
      if (response != m.response)
      {
         return(false);
      }
      if (morphognostic.compare(m.morphognostic) != 0.0f)
      {
         return(false);
      }
      return(true);
   }


   // Save.
   public void save(FileOutputStream output) throws IOException
   {
      DataOutputStream writer = new DataOutputStream(output);

      morphognostic.save(output);
      Utility.saveInt(writer, response);
      writer.writeUTF(responseName);
      writer.flush();
   }


   // Load.
   public static Metamorph load(FileInputStream input) throws IOException
   {
      DataInputStream reader        = new DataInputStream(input);
      Morphognostic   morphognostic = Morphognostic.load(input);
      int             response      = Utility.loadInt(reader);
      String          responseName  = reader.readUTF();

      return(new Metamorph(morphognostic, response, responseName));
   }


   // Print.
   public void print()
   {
      System.out.println("Morphognostic:");
      morphognostic.print();
      System.out.println("Response=" + response);
      System.out.println("ResponseName=" + responseName);
   }
}
