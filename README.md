🚀 8085 Microprocessor Simulator

📌 Overview
The 8085 Microprocessor Simulator is a Java-based application that emulates the functionality of the Intel 8085. It allows users to execute assembly instructions, visualize register states, and understand how instructions affect flags and memory at a low level.
This project focuses on simulating instruction execution cycle, flag behavior, and memory operations, making it useful for students learning computer organization and microprocessors.

🎯 Key Features: 
1. Execution of 8085 assembly instructions
2. Register simulation (A, B, C, D, E, H, L)
3. Memory read/write operations
4. Instruction parsing and execution engine
5. Accurate flag handling (CY, AC, Z, S, P)
6. Step-by-step debugging support
7. Clean modular architecture
8. Flags Supported

The simulator correctly handles all important flags:
   Flag	                  Description
CY (Carry)	    :    Set on overflow / borrow
AC (Aux Carry)	:   Set on nibble overflow
Z (Zero)	    :   Set if result = 0
S (Sign)	    :   Set if MSB = 1
P (Parity)	    :   Set for even parity


⚙️ Supported Instructions
🔹 Data Transfer : MOV, MVI, LDA, STA
🔹 Arithmetic: ADD, ADI, ADC, ACI, SUB, SUI, SBB
🔹 Logical : ANA, ANI, ORA, ORI, XRA, XRI, CMA
🔹 Increment / Decrement : INR, DCR
🔹 Comparison : CMP, CPI
🔹 Control : HLT, RST5


🏗️ System Design 
Instruction Parser - Parses assembly instructions into executable operations
Execution Engine - Simulates instruction execution cycle
Register Module - Maintains register values
Memory Module - Handles memory operations
Flag Module - Computes CY, AC, Z, S, P based on operations


🚀 How to Run
1. Clone the repository
2. Compile the project
3. Run the simulator
4. Enter 8085 instructions
5. Observe register and flag changes

📚 Learning Outcomes
Understanding of instruction execution cycle
Deep knowledge of flag behavior
Low-level system simulation
Assembly-level programming concepts