package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class GTinstr extends ZeroOperandInstruction {

  void execute ()
  {
    /* ???????? */
	ESP--;
	EXPRSTACK[ESP - 1]=(EXPRSTACK[ESP - 1] > EXPRSTACK[ESP])?1:0;
  }

  public GTinstr ()
  {
    super("GT");
  }
}

