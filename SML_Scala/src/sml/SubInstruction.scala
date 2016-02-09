package sml

class SubInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {
  override def execute(m: Machine){
    println(this)
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) =  value1 - value2
  }

  override def toString(): String = {
    super.toString + " " + op2 + " - " + op1 + " to " + result
  }
}

object SubInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int) =
    new SubInstruction(label, "sub", result, op1, op2)
}