package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;
import TJasn.TJ;
import TJasn.virtualMachine.VirtualMachineHaltException;

public class LOADFROMADDRinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
       /* ???????? */
	   int data = EXPRSTACK[ESP - 1]-POINTERTAG;
	   EXPRSTACK[ESP - 1] = TJ.data[data];
  }

  public LOADFROMADDRinstr ()
  {
    super("LOADFROMADDR");
  }
}

