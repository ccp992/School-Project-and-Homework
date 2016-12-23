package TJasn.virtualMachine;

import TJasn.TJ;

public class WRITESTRINGinstr extends TwoOperandInstruction {

  void execute ()
  {
    /* ???????? */
	for(int op = this.firstOperand; op <= this.secondOperand; op++){
		System.out.print((char)(TJ.data[op]));
	}
  }

  public WRITESTRINGinstr (int startOffset, int endOffset)
  {
    super(startOffset, endOffset, "WRITESTRING");
  }
}

