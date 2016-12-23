/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  TJ1asn.SourceFileErrorException
 *  TJasn.OutputFileHandler
 *  TJasn.ParserAndTranslator$1
 *  TJasn.ParserAndTranslator$IdentList
 *  TJasn.ParserAndTranslator$ParameterList
 *  TJasn.TJ
 *  TJasn.symbolTable.BlockRec
 *  TJasn.symbolTable.ClassVariableRec
 *  TJasn.symbolTable.CompoundStmtBlockRec
 *  TJasn.symbolTable.FixUpRec
 *  TJasn.symbolTable.LocalVariableRec
 *  TJasn.symbolTable.MethodBlockRec
 *  TJasn.symbolTable.MethodRec
 *  TJasn.symbolTable.TabRec
 *  TJasn.symbolTable.VariableRec
 *  TJasn.virtualMachine.ADDTOPTRinstr
 *  TJasn.virtualMachine.ADDinstr
 *  TJasn.virtualMachine.ANDinstr
 *  TJasn.virtualMachine.CALLSTATMETHODinstr
 *  TJasn.virtualMachine.CHANGESIGNinstr
 *  TJasn.virtualMachine.DIVinstr
 *  TJasn.virtualMachine.EQinstr
 *  TJasn.virtualMachine.GEinstr
 *  TJasn.virtualMachine.GTinstr
 *  TJasn.virtualMachine.HEAPALLOCinstr
 *  TJasn.virtualMachine.INITSTKFRMinstr
 *  TJasn.virtualMachine.Instruction
 *  TJasn.virtualMachine.JUMPONFALSEinstr
 *  TJasn.virtualMachine.JUMPinstr
 *  TJasn.virtualMachine.LEinstr
 *  TJasn.virtualMachine.LOADFROMADDRinstr
 *  TJasn.virtualMachine.LTinstr
 *  TJasn.virtualMachine.MODinstr
 *  TJasn.virtualMachine.MULinstr
 *  TJasn.virtualMachine.NEinstr
 *  TJasn.virtualMachine.NOPorDISCARDVALUEinstr
 *  TJasn.virtualMachine.NOTinstr
 *  TJasn.virtualMachine.ORinstr
 *  TJasn.virtualMachine.OneOperandInstruction
 *  TJasn.virtualMachine.PASSPARAMinstr
 *  TJasn.virtualMachine.PUSHLOCADDRinstr
 *  TJasn.virtualMachine.PUSHNUMinstr
 *  TJasn.virtualMachine.PUSHSTATADDRinstr
 *  TJasn.virtualMachine.READINTinstr
 *  TJasn.virtualMachine.RETURNinstr
 *  TJasn.virtualMachine.SAVETOADDRinstr
 *  TJasn.virtualMachine.STOPinstr
 *  TJasn.virtualMachine.SUBinstr
 *  TJasn.virtualMachine.WRITEINTinstr
 *  TJasn.virtualMachine.WRITELNOPinstr
 *  TJasn.virtualMachine.WRITESTRINGinstr
 *  TJlexer.LexicalAnalyzer
 *  TJlexer.Symbols
 */
package TJasn;

import TJ1asn.SourceFileErrorException;
import TJasn.OutputFileHandler;
import TJasn.ParserAndTranslator;
import TJasn.TJ;
import TJasn.symbolTable.BlockRec;
import TJasn.symbolTable.ClassVariableRec;
import TJasn.symbolTable.CompoundStmtBlockRec;
import TJasn.symbolTable.FixUpRec;
import TJasn.symbolTable.LocalVariableRec;
import TJasn.symbolTable.MethodBlockRec;
import TJasn.symbolTable.MethodRec;
import TJasn.symbolTable.TabRec;
import TJasn.symbolTable.VariableRec;
import TJasn.virtualMachine.ADDTOPTRinstr;
import TJasn.virtualMachine.ADDinstr;
import TJasn.virtualMachine.ANDinstr;
import TJasn.virtualMachine.CALLSTATMETHODinstr;
import TJasn.virtualMachine.CHANGESIGNinstr;
import TJasn.virtualMachine.DIVinstr;
import TJasn.virtualMachine.EQinstr;
import TJasn.virtualMachine.GEinstr;
import TJasn.virtualMachine.GTinstr;
import TJasn.virtualMachine.HEAPALLOCinstr;
import TJasn.virtualMachine.INITSTKFRMinstr;
import TJasn.virtualMachine.Instruction;
import TJasn.virtualMachine.JUMPONFALSEinstr;
import TJasn.virtualMachine.JUMPinstr;
import TJasn.virtualMachine.LEinstr;
import TJasn.virtualMachine.LOADFROMADDRinstr;
import TJasn.virtualMachine.LTinstr;
import TJasn.virtualMachine.MODinstr;
import TJasn.virtualMachine.MULinstr;
import TJasn.virtualMachine.NEinstr;
import TJasn.virtualMachine.NOPorDISCARDVALUEinstr;
import TJasn.virtualMachine.NOTinstr;
import TJasn.virtualMachine.ORinstr;
import TJasn.virtualMachine.OneOperandInstruction;
import TJasn.virtualMachine.PASSPARAMinstr;
import TJasn.virtualMachine.PUSHLOCADDRinstr;
import TJasn.virtualMachine.PUSHNUMinstr;
import TJasn.virtualMachine.PUSHSTATADDRinstr;
import TJasn.virtualMachine.READINTinstr;
import TJasn.virtualMachine.RETURNinstr;
import TJasn.virtualMachine.SAVETOADDRinstr;
import TJasn.virtualMachine.STOPinstr;
import TJasn.virtualMachine.SUBinstr;
import TJasn.virtualMachine.WRITEINTinstr;
import TJasn.virtualMachine.WRITELNOPinstr;
import TJasn.virtualMachine.WRITESTRINGinstr;
import TJlexer.LexicalAnalyzer;
import TJlexer.Symbols;

public final class ParserAndTranslator {
    private static int level = 1;
    private static Boolean ScannerImported = false;

    public static int getLevel() {
        return level;
    }

    private static void accept(Symbols symbols) throws SourceFileErrorException {
        if (LexicalAnalyzer.getCurrentToken() != symbols) {
            throw new SourceFileErrorException("Something's wrong--maybe the following token is missing: " + symbols.symbolRepresentationForOutputFile);
        }
        LexicalAnalyzer.nextToken();
    }

    private static MethodRec lookUpCalledMethod(String string, int n) throws SourceFileErrorException {
        MethodRec methodRec = (MethodRec)BlockRec.searchForStatic((String)string, (Boolean)true);
        if (methodRec == null) {
            methodRec = new MethodRec(string, n, -2);
            methodRec.setStartAddr(-10000);
            MethodRec.incUndeclaredMethodCount();
        } else if (n != -2) {
            if (methodRec.getType() == -2) {
                methodRec.setType(n);
            } else if (n != methodRec.getType()) {
                throw new SourceFileErrorException("Method does not have appropriate return type");
            }
        }
        return methodRec;
    }

    static void program() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTprogram);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.IMPORT) {
            ScannerImported = true;
            ParserAndTranslator.importStmt();
        }
        ParserAndTranslator.accept(Symbols.CLASS);
        ParserAndTranslator.accept(Symbols.IDENT);
        ParserAndTranslator.accept(Symbols.LBRACE);
        while (LexicalAnalyzer.getCurrentToken() == Symbols.STATIC) {
            ParserAndTranslator.dataFieldDecl();
        }
        TJ.staticTab.setLastStaticVarAddr(TJ.staticTab.getNextOffset() - 1);
        LexicalAnalyzer.setEndOfString((int)TJ.staticTab.getLastStaticVarAddr());
        ParserAndTranslator.mainDecl();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.STATIC) {
            ParserAndTranslator.methodDecl();
        }
        if (MethodRec.getUndeclaredMethodCount() != 0) {
            throw new SourceFileErrorException("Not all called methods have been declared");
        }
        ParserAndTranslator.accept(Symbols.RBRACE);
        TJ.output.decTreeDepth();
    }

    private static void importStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTimport);
        TJ.output.incTreeDepth();
        ParserAndTranslator.accept(Symbols.IMPORT);
        ParserAndTranslator.accept(Symbols.JAVA);
        ParserAndTranslator.accept(Symbols.DOT);
        ParserAndTranslator.accept(Symbols.UTIL);
        ParserAndTranslator.accept(Symbols.DOT);
        ParserAndTranslator.accept(Symbols.SCANNER);
        ParserAndTranslator.accept(Symbols.SEMICOLON);
        TJ.output.decTreeDepth();
    }

    private static void dataFieldDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTdataFieldDecl);
        TJ.output.incTreeDepth();
        ParserAndTranslator.accept(Symbols.STATIC);
        ParserAndTranslator.varDecl();
        TJ.output.decTreeDepth();
    }

    private static void varDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTvarDecl);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.INT) {
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.singleVarDecl();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.COMMA) {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.singleVarDecl();
            }
            ParserAndTranslator.accept(Symbols.SEMICOLON);
        } else if (LexicalAnalyzer.getCurrentToken() == Symbols.SCANNER) {
            if (!ScannerImported.booleanValue()) {
                throw new SourceFileErrorException("Scanner used without having been imported");
            }
            LexicalAnalyzer.nextToken();
            if (LexicalAnalyzer.getCurrentToken() == Symbols.IDENT) {
                if (level == 1) {
                    if (BlockRec.searchForStatic((String)LexicalAnalyzer.getCurrentSpelling(), (Boolean)false) != null) {
                        throw new SourceFileErrorException("Illegal redeclaration of class variable " + LexicalAnalyzer.getCurrentSpelling());
                    }
                    new ClassVariableRec(LexicalAnalyzer.getCurrentSpelling());
                } else {
                    if (TJ.symTab.searchForLocal(LexicalAnalyzer.getCurrentSpelling()) != null) {
                        throw new SourceFileErrorException("Illegal redeclaration of local variable " + LexicalAnalyzer.getCurrentSpelling());
                    }
                    new LocalVariableRec(LexicalAnalyzer.getCurrentSpelling());
                }
            } else {
                throw new SourceFileErrorException("Scanner name expected");
            }
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.accept(Symbols.BECOMES);
            ParserAndTranslator.accept(Symbols.NEW);
            ParserAndTranslator.accept(Symbols.SCANNER);
            ParserAndTranslator.accept(Symbols.LPAREN);
            ParserAndTranslator.accept(Symbols.SYSTEM);
            ParserAndTranslator.accept(Symbols.DOT);
            ParserAndTranslator.accept(Symbols.IN);
            ParserAndTranslator.accept(Symbols.RPAREN);
            ParserAndTranslator.accept(Symbols.SEMICOLON);
        } else {
            throw new SourceFileErrorException("\"int\" or \"Scanner\" expected");
        }
        TJ.output.decTreeDepth();
    }

    private static void singleVarDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTsingleVarDecl);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.IDENT) {
            LocalVariableRec localVariableRec = null;
            String string = LexicalAnalyzer.getCurrentSpelling();
            int n = 0;
            LexicalAnalyzer.nextToken();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                ++n;
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.accept(Symbols.RBRACKET);
            }
            if (level == 1) {
                if (BlockRec.searchForStatic((String)string, (Boolean)false) != null) {
                    throw new SourceFileErrorException("Illegal redeclaration of class variable " + LexicalAnalyzer.getCurrentSpelling());
                }
                int n2 = TJ.staticTab.getNextOffset();
                localVariableRec = new ClassVariableRec(string, 0, n, n2);
                TJ.staticTab.setNextOffset(n2 + 1);
            } else {
                if (TJ.symTab.searchForLocal(string) != null) {
                    throw new SourceFileErrorException("Illegal redeclaration of local variable " + LexicalAnalyzer.getCurrentSpelling());
                }
                int n3 = TJ.symTab.getNextOffset();
                localVariableRec = new LocalVariableRec(string, 0, n, n3);
                TJ.symTab.setNextOffset(n3 + 1);
            }
            if (LexicalAnalyzer.getCurrentToken() == Symbols.BECOMES) {
                LexicalAnalyzer.nextToken();
                if (level == 1) {
                    new PUSHSTATADDRinstr(localVariableRec.offset);
                } else {
                    new PUSHLOCADDRinstr(localVariableRec.offset);
                }
                ParserAndTranslator.expr3();
                new SAVETOADDRinstr();
            }
        } else {
            throw new SourceFileErrorException("Variable name expected");
        }
        TJ.output.decTreeDepth();
    }

    private static void mainDecl() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTmainDecl);
        TJ.output.incTreeDepth();
        ParserAndTranslator.accept(Symbols.PUBLIC);
        ParserAndTranslator.accept(Symbols.STATIC);
        ParserAndTranslator.accept(Symbols.VOID);
        ParserAndTranslator.accept(Symbols.MAIN);
        ParserAndTranslator.accept(Symbols.LPAREN);
        ParserAndTranslator.accept(Symbols.STRING);
        ParserAndTranslator.accept(Symbols.IDENT);
        ParserAndTranslator.accept(Symbols.LBRACKET);
        ParserAndTranslator.accept(Symbols.RBRACKET);
        ParserAndTranslator.accept(Symbols.RPAREN);
        MethodRec methodRec = new MethodRec("main", -1, 0);
        methodRec.setStartAddr(Instruction.getNextCodeAddress());
        INITSTKFRMinstr iNITSTKFRMinstr = new INITSTKFRMinstr(-10000);
        ParserAndTranslator.compoundStmt(methodRec, null);
        iNITSTKFRMinstr.fixUpOperand(methodRec.getTable().getMaxNextOffset() - 1);
        new STOPinstr();
        TJ.output.decTreeDepth();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void methodDecl() throws SourceFileErrorException {
        int n;
        INITSTKFRMinstr iNITSTKFRMinstr = null;
        int n2 = 0;
        TJ.output.printSymbol(Symbols.NTmethodDecl);
        TJ.output.incTreeDepth();
        ParserAndTranslator.accept(Symbols.STATIC);
        if (LexicalAnalyzer.getCurrentToken() == Symbols.INT) {
            n = 0;
            LexicalAnalyzer.nextToken();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                ++n2;
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.accept(Symbols.RBRACKET);
            }
        } else {
            n = -1;
            ParserAndTranslator.accept(Symbols.VOID);
        }
        MethodRec methodRec = null;
        if (LexicalAnalyzer.getCurrentToken() != Symbols.IDENT) throw new SourceFileErrorException("Method name expected");
        methodRec = (MethodRec)BlockRec.searchForStatic((String)LexicalAnalyzer.getCurrentSpelling(), (Boolean)true);
        if (methodRec == null) {
            methodRec = new MethodRec(LexicalAnalyzer.getCurrentSpelling(), n, n2);
        } else {
            if (methodRec.getCallsToBeFixedUp() == null) throw new SourceFileErrorException("Method " + LexicalAnalyzer.getCurrentSpelling() + " has already been declared");
            methodRec.getCallsToBeFixedUp().redirectThemToHere(n);
            methodRec.setCallsToBeFixedUp(null);
            methodRec.setDimensionCount(n2);
            if (methodRec.getType() == -2) {
                methodRec.setType(n);
            } else if (methodRec.getType() != n) {
                throw new SourceFileErrorException("Declared return type inconsistent with earlier call of this method");
            }
            MethodRec.decUndeclaredMethodCount();
        }
        methodRec.setStartAddr(Instruction.getNextCodeAddress());
        iNITSTKFRMinstr = new INITSTKFRMinstr(-10000);
        LexicalAnalyzer.nextToken();
        ParserAndTranslator.accept(Symbols.LPAREN);
        ParameterList parameterList = ParserAndTranslator.parameterDeclList();
        ParserAndTranslator.accept(Symbols.RPAREN);
        if (methodRec.getArgCount() == -2) {
            methodRec.setArgCount(parameterList.paramCount);
        } else if (methodRec.getArgCount() != parameterList.paramCount) {
            throw new SourceFileErrorException("Method " + methodRec.name + " was previously called with " + methodRec.getArgCount() + " arguments");
        }
        ParserAndTranslator.compoundStmt(methodRec, parameterList.theParams);
        iNITSTKFRMinstr.fixUpOperand(methodRec.getTable().getMaxNextOffset() - 1);
        if (methodRec.getType() == -1) {
            new RETURNinstr(methodRec.getArgCount());
        }
        TJ.output.decTreeDepth();
    }

    private static ParameterList parameterDeclList() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTparameterDeclList);
        TJ.output.incTreeDepth();
        ParameterList parameterList = new ParameterList(null);
        if (LexicalAnalyzer.getCurrentToken() == Symbols.INT) {
            ParserAndTranslator.parameterDecl(parameterList);
            while (LexicalAnalyzer.getCurrentToken() == Symbols.COMMA) {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.parameterDecl(parameterList);
            }
        } else {
            TJ.output.printSymbol(Symbols.EMPTY);
        }
        TJ.output.decTreeDepth();
        return parameterList;
    }

    private static void parameterDecl(ParameterList parameterList) throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTparameterDecl);
        TJ.output.incTreeDepth();
        IdentList identList = new IdentList(null);
        ParserAndTranslator.accept(Symbols.INT);
        if (LexicalAnalyzer.getCurrentToken() == Symbols.IDENT) {
            identList.name = LexicalAnalyzer.getCurrentSpelling();
            identList.next = parameterList.theParams;
            parameterList.theParams = identList;
            ++parameterList.paramCount;
        }
        ParserAndTranslator.accept(Symbols.IDENT);
        while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
            ++identList.dimensions;
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.accept(Symbols.RBRACKET);
        }
        TJ.output.decTreeDepth();
    }

    private static void compoundStmt(MethodRec methodRec, IdentList identList) throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTcompoundStmt);
        TJ.output.incTreeDepth();
        ++level;
        if (methodRec == null) {
            TJ.symTab = new CompoundStmtBlockRec();
        } else {
            TJ.symTab = new MethodBlockRec(methodRec);
            int n = -1;
            IdentList identList2 = identList;
            while (identList2 != null) {
                if (TJ.symTab.searchForLocal(identList2.name) != null) {
                    throw new SourceFileErrorException("Illegal redeclaration of parameter " + identList2.name);
                }
                new LocalVariableRec(identList2.name, 0, identList2.dimensions, --n);
                identList2 = identList2.next;
            }
        }
        ParserAndTranslator.accept(Symbols.LBRACE);
        while (LexicalAnalyzer.getCurrentToken() != Symbols.RBRACE) {
            ParserAndTranslator.statement();
        }
        LexicalAnalyzer.nextToken();
        MethodBlockRec methodBlockRec = ((CompoundStmtBlockRec)TJ.symTab).methodBlock;
        methodBlockRec.setMaxNextOffset(Math.max(TJ.symTab.getNextOffset(), methodBlockRec.getMaxNextOffset()));
        TJ.symTab = TJ.symTab.enclosingBlock;
        --level;
        TJ.output.decTreeDepth();
    }

    private static void statement() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTstatement);
        TJ.output.incTreeDepth();
        switch (1.$SwitchMap$TJlexer$Symbols[LexicalAnalyzer.getCurrentToken().ordinal()]) {
            case 1: {
                LexicalAnalyzer.nextToken();
                break;
            }
            case 2: {
                LexicalAnalyzer.nextToken();
                if (((CompoundStmtBlockRec)TJ.symTab).methodBlock.methodRec.getType() == 0) {
                    ParserAndTranslator.expr3();
                }
                new RETURNinstr(((CompoundStmtBlockRec)TJ.symTab).methodBlock.methodRec.getArgCount());
                ParserAndTranslator.accept(Symbols.SEMICOLON);
                break;
            }
            case 3: 
            case 4: {
                ParserAndTranslator.varDecl();
                break;
            }
            case 5: {
                ParserAndTranslator.assignmentOrInvoc();
                break;
            }
            case 6: {
                ParserAndTranslator.compoundStmt(null, null);
                break;
            }
            case 7: {
                ParserAndTranslator.ifStmt();
                break;
            }
            case 8: {
                ParserAndTranslator.whileStmt();
                break;
            }
            case 9: {
                ParserAndTranslator.outputStmt();
                break;
            }
            default: {
                throw new SourceFileErrorException("Expected first token of a <statement>, not " + LexicalAnalyzer.getCurrentToken().symbolRepresentationForOutputFile);
            }
        }
        TJ.output.decTreeDepth();
    }

    private static void assignmentOrInvoc() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTassignmentOrInvoc);
        TJ.output.incTreeDepth();
        String string = LexicalAnalyzer.getCurrentSpelling();
        ParserAndTranslator.accept(Symbols.IDENT);
        if (LexicalAnalyzer.getCurrentToken() != Symbols.LPAREN) {
            VariableRec variableRec = TJ.symTab.searchForVariable(string);
            if (variableRec == null) {
                throw new SourceFileErrorException("Undeclared variable: " + string);
            }
            if (variableRec.type != 0) {
                throw new SourceFileErrorException("int variable expected");
            }
            if (variableRec instanceof LocalVariableRec) {
                new PUSHLOCADDRinstr(variableRec.offset);
            } else {
                new PUSHSTATADDRinstr(variableRec.offset);
            }
            int n = 0;
            while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                new LOADFROMADDRinstr();
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.expr3();
                ParserAndTranslator.accept(Symbols.RBRACKET);
                new ADDTOPTRinstr();
                ++n;
            }
            if (n > variableRec.dimensionCount) {
                throw new SourceFileErrorException("Unexpected index(es)");
            }
            ParserAndTranslator.accept(Symbols.BECOMES);
            ParserAndTranslator.expr3();
            new SAVETOADDRinstr();
            ParserAndTranslator.accept(Symbols.SEMICOLON);
        } else {
            MethodRec methodRec = ParserAndTranslator.lookUpCalledMethod(string, -2);
            ParserAndTranslator.argumentList(methodRec);
            CALLSTATMETHODinstr cALLSTATMETHODinstr = new CALLSTATMETHODinstr(methodRec.getStartAddr());
            if (methodRec.getStartAddr() == -10000) {
                if (methodRec.getType() == -2) {
                    methodRec.setCallsToBeFixedUp(new FixUpRec((OneOperandInstruction)cALLSTATMETHODinstr, methodRec.getCallsToBeFixedUp(), new NOPorDISCARDVALUEinstr()));
                } else {
                    methodRec.setCallsToBeFixedUp(new FixUpRec((OneOperandInstruction)cALLSTATMETHODinstr, methodRec.getCallsToBeFixedUp()));
                    if (methodRec.getType() != -1) {
                        new NOPorDISCARDVALUEinstr(false);
                    }
                }
            } else if (methodRec.getType() != -1) {
                new NOPorDISCARDVALUEinstr(false);
            }
            ParserAndTranslator.accept(Symbols.SEMICOLON);
        }
        TJ.output.decTreeDepth();
    }

    private static void argumentList(MethodRec methodRec) throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTargumentList);
        TJ.output.incTreeDepth();
        int n = 0;
        ParserAndTranslator.accept(Symbols.LPAREN);
        if (LexicalAnalyzer.getCurrentToken() != Symbols.RPAREN) {
            ParserAndTranslator.expr3();
            ++n;
            new PASSPARAMinstr();
            while (LexicalAnalyzer.getCurrentToken() == Symbols.COMMA) {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.expr3();
                ++n;
                new PASSPARAMinstr();
            }
        }
        if (methodRec.getArgCount() == -2) {
            methodRec.setArgCount(n);
        } else if (methodRec.getArgCount() != n) {
            throw new SourceFileErrorException("Method " + methodRec.name + " was declared or previously called with " + methodRec.getArgCount() + " arguments");
        }
        ParserAndTranslator.accept(Symbols.RPAREN);
        TJ.output.decTreeDepth();
    }

    private static void ifStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTifStmt);
        TJ.output.incTreeDepth();
        ParserAndTranslator.accept(Symbols.IF);
        ParserAndTranslator.accept(Symbols.LPAREN);
        ParserAndTranslator.expr7();
        ParserAndTranslator.accept(Symbols.RPAREN);
        JUMPONFALSEinstr jUMPONFALSEinstr = new JUMPONFALSEinstr(-10000);
        ParserAndTranslator.statement();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.ELSE) {
            LexicalAnalyzer.nextToken();
            JUMPinstr jUMPinstr = new JUMPinstr(-10000);
            jUMPONFALSEinstr.fixUpOperand(Instruction.getNextCodeAddress());
            ParserAndTranslator.statement();
            jUMPinstr.fixUpOperand(Instruction.getNextCodeAddress());
        } else {
            jUMPONFALSEinstr.fixUpOperand(Instruction.getNextCodeAddress());
        }
        TJ.output.decTreeDepth();
    }

    private static void whileStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTwhileStmt);
        TJ.output.incTreeDepth();
        int n = Instruction.getNextCodeAddress();
        ParserAndTranslator.accept(Symbols.WHILE);
        ParserAndTranslator.accept(Symbols.LPAREN);
        ParserAndTranslator.expr7();
        ParserAndTranslator.accept(Symbols.RPAREN);
        JUMPONFALSEinstr jUMPONFALSEinstr = new JUMPONFALSEinstr(-10000);
        ParserAndTranslator.statement();
        new JUMPinstr(n);
        jUMPONFALSEinstr.fixUpOperand(Instruction.getNextCodeAddress());
        TJ.output.decTreeDepth();
    }

    private static void outputStmt() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NToutputStmt);
        TJ.output.incTreeDepth();
        ParserAndTranslator.accept(Symbols.SYSTEM);
        ParserAndTranslator.accept(Symbols.DOT);
        ParserAndTranslator.accept(Symbols.OUT);
        ParserAndTranslator.accept(Symbols.DOT);
        switch (1.$SwitchMap$TJlexer$Symbols[LexicalAnalyzer.getCurrentToken().ordinal()]) {
            case 10: {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.accept(Symbols.LPAREN);
                ParserAndTranslator.printArgument();
                ParserAndTranslator.accept(Symbols.RPAREN);
                ParserAndTranslator.accept(Symbols.SEMICOLON);
                break;
            }
            case 11: {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.accept(Symbols.LPAREN);
                if (LexicalAnalyzer.getCurrentToken() != Symbols.RPAREN) {
                    ParserAndTranslator.printArgument();
                }
                ParserAndTranslator.accept(Symbols.RPAREN);
                ParserAndTranslator.accept(Symbols.SEMICOLON);
                new WRITELNOPinstr();
                break;
            }
            default: {
                throw new SourceFileErrorException("print() or println() expected, not " + LexicalAnalyzer.getCurrentToken().symbolRepresentationForOutputFile);
            }
        }
        TJ.output.decTreeDepth();
    }

    private static void printArgument() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTprintArgument);
        TJ.output.incTreeDepth();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.CHARSTRING) {
            new WRITESTRINGinstr(LexicalAnalyzer.getStartOfString(), LexicalAnalyzer.getEndOfString());
            LexicalAnalyzer.nextToken();
        } else {
            ParserAndTranslator.expr3();
            new WRITEINTinstr();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr7() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr7);
        TJ.output.incTreeDepth();
        ParserAndTranslator.expr6();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.OR) {
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.expr6();
            new ORinstr();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr6() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr6);
        TJ.output.incTreeDepth();
        ParserAndTranslator.expr5();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.AND) {
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.expr5();
            new ANDinstr();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr5() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr5);
        TJ.output.incTreeDepth();
        ParserAndTranslator.expr4();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.EQ || LexicalAnalyzer.getCurrentToken() == Symbols.NE) {
            Symbols symbols = LexicalAnalyzer.getCurrentToken();
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.expr4();
            if (symbols == Symbols.EQ) {
                new EQinstr();
                continue;
            }
            new NEinstr();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr4() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr4);
        TJ.output.incTreeDepth();
        ParserAndTranslator.expr3();
        if (LexicalAnalyzer.getCurrentToken() == Symbols.LT || LexicalAnalyzer.getCurrentToken() == Symbols.LE || LexicalAnalyzer.getCurrentToken() == Symbols.GT || LexicalAnalyzer.getCurrentToken() == Symbols.GE) {
            Symbols symbols = LexicalAnalyzer.getCurrentToken();
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.expr3();
            if (symbols == Symbols.LT) {
                new LTinstr();
            } else if (symbols == Symbols.LE) {
                new LEinstr();
            } else if (symbols == Symbols.GT) {
                new GTinstr();
            } else {
                new GEinstr();
            }
        }
        TJ.output.decTreeDepth();
    }

    private static void expr3() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr3);
        TJ.output.incTreeDepth();
        ParserAndTranslator.expr2();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.PLUS || LexicalAnalyzer.getCurrentToken() == Symbols.MINUS) {
            Symbols symbols = LexicalAnalyzer.getCurrentToken();
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.expr2();
            if (symbols == Symbols.PLUS) {
                new ADDinstr();
                continue;
            }
            new SUBinstr();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr2() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr2);
        TJ.output.incTreeDepth();
        ParserAndTranslator.expr1();
        while (LexicalAnalyzer.getCurrentToken() == Symbols.TIMES || LexicalAnalyzer.getCurrentToken() == Symbols.DIV || LexicalAnalyzer.getCurrentToken() == Symbols.MOD) {
            Symbols symbols = LexicalAnalyzer.getCurrentToken();
            LexicalAnalyzer.nextToken();
            ParserAndTranslator.expr1();
            if (symbols == Symbols.TIMES) {
                new MULinstr();
                continue;
            }
            if (symbols == Symbols.DIV) {
                new DIVinstr();
                continue;
            }
            new MODinstr();
        }
        TJ.output.decTreeDepth();
    }

    private static void expr1() throws SourceFileErrorException {
        TJ.output.printSymbol(Symbols.NTexpr1);
        TJ.output.incTreeDepth();
        switch (1.$SwitchMap$TJlexer$Symbols[LexicalAnalyzer.getCurrentToken().ordinal()]) {
			
            case 12: {
                new PUSHNUMinstr(LexicalAnalyzer.getCurrentValue());
                LexicalAnalyzer.nextToken();
                break;
            }
            case 5: {
                int n;
                MethodRec methodRec;
                String string = LexicalAnalyzer.getCurrentSpelling();
                LexicalAnalyzer.nextToken();
                if (LexicalAnalyzer.getCurrentToken() == Symbols.DOT) {
                    VariableRec variableRec = TJ.symTab.searchForVariable(string);
                    if (variableRec == null) {
                        throw new SourceFileErrorException("Undeclared variable: " + string);
                    }
                    if (variableRec.type == 1) {
                        LexicalAnalyzer.nextToken();
                        ParserAndTranslator.accept(Symbols.NEXTINT);
                        ParserAndTranslator.accept(Symbols.LPAREN);
                        ParserAndTranslator.accept(Symbols.RPAREN);
                        new READINTinstr();
                        break;
                    }
                    throw new SourceFileErrorException("Scanner variable expected");
                }
                if (LexicalAnalyzer.getCurrentToken() == Symbols.LPAREN) {
                    methodRec = ParserAndTranslator.lookUpCalledMethod(string, 0);
                    ParserAndTranslator.argumentList(methodRec);
                    CALLSTATMETHODinstr cALLSTATMETHODinstr = new CALLSTATMETHODinstr(methodRec.getStartAddr());
                    if (methodRec.getStartAddr() == -10000) {
                        methodRec.setCallsToBeFixedUp(new FixUpRec((OneOperandInstruction)cALLSTATMETHODinstr, methodRec.getCallsToBeFixedUp()));
                    }
                    n = methodRec.getDimensionCount();
                } else {
                    methodRec = TJ.symTab.searchForVariable(string);
                    if (methodRec == null) {
                        throw new SourceFileErrorException("Undeclared variable: " + string);
                    }
                    if (methodRec.type != 0) {
                        throw new SourceFileErrorException("Integer variable expected");
                    }
                    if (methodRec instanceof LocalVariableRec) {
                        new PUSHLOCADDRinstr(methodRec.offset);
                    } else {
                        new PUSHSTATADDRinstr(methodRec.offset);
                    }
                    new LOADFROMADDRinstr();
                    n = methodRec.dimensionCount;
                }
                while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                    if (n-- == 0) {
                        throw new SourceFileErrorException("Unexpected index expression");
                    }
                    LexicalAnalyzer.nextToken();
                    ParserAndTranslator.expr3();
                    new ADDTOPTRinstr();
                    new LOADFROMADDRinstr();
                    ParserAndTranslator.accept(Symbols.RBRACKET);
                }
                break;
            }
            case 13: {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.expr7();
                ParserAndTranslator.accept(Symbols.RPAREN);
                break;
            }
            case 14: 
            case 15: 
            case 16: {
                Symbols symbols = LexicalAnalyzer.getCurrentToken();
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.expr1();
                if (symbols == Symbols.MINUS) {
                    new CHANGESIGNinstr();
                    break;
                }
                if (symbols != Symbols.NOT) break;
                new NOTinstr();
                break;
            }
            case 17: {
                LexicalAnalyzer.nextToken();
                ParserAndTranslator.accept(Symbols.INT);
                ParserAndTranslator.accept(Symbols.LBRACKET);
                ParserAndTranslator.expr3();
                new HEAPALLOCinstr();
                ParserAndTranslator.accept(Symbols.RBRACKET);
                while (LexicalAnalyzer.getCurrentToken() == Symbols.LBRACKET) {
                    LexicalAnalyzer.nextToken();
                    ParserAndTranslator.accept(Symbols.RBRACKET);
                }
                break;
            }
            case 18: {
                LexicalAnalyzer.nextToken();
                new PUSHNUMinstr(0);
                break;
            }
            default: {
                throw new SourceFileErrorException("Malformed expression");
            }
        }
        TJ.output.decTreeDepth();
    }
}