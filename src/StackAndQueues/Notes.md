## Monotonic Stack
Whevever we are storing a stack whic is in a specific order then it is called as a monotonic stact
- Storing in ascending order
- Descending order 
- Any other specific order

Stack Cheat Sheet

## Basic Concepts

Operand:

- An operand is a value or variable on which operators act.
- Example: In A + B, A and B are operands.

Operator:

- An operator defines the operation to perform on operands.
- Example: +, -, \*, /, ^

## Priority / Precedence of Operators (Highest to Lowest):

^           :   3   : Exponentiation (Right to Left)
*, /, %     :   2   : Multiplication, Division, Modulus (Left to Right)
+, -        :   1   : Addition, Subtraction (Left to Right)

## Expression Notations

1. Infix:

   - The operator is between operands.
   - Used in most of the programmig language standard way of defining the equation.
   - Example: A + B

2. Postfix (Reverse Polish Notation):

   - The operator is after operands.
   - Used in stack based calculator
   - Example: A B +

3. Prefix (Polish Notation):

   - The operator is before operands.
   - Used in LISP Programming language
   - Used in Tree (Prefix Tree)
   - Example: + A B

## Conversions

Infix to Postfix:

- Use a stack for operators.
- Output operands directly.
- Apply precedence and associativity for operator stack.
A + B - C  
A B C - +

Infix to Prefix:

- Reverse the infix expression.
- Swap ( and ).
- Convert to postfix.
- Reverse the result.
(A + B) - C 
- + A B C

Postfix to Infix:

- Use a stack.
- Push operands to the stack.
- When an operator is found, pop 2 operands and combine as (operand1 operator operand2).
- Push back the result.
A B + 
(A + B)

Postfix to Prefix:

- Use a stack.
- Push operands to the stack.
- When an operator is found, pop 2 operands and combine as operator operand1 operand2.
- Push back the result.
A B + 
+ A B

Prefix to Infix:

- Traverse from right to left.
- Use a stack.
- Push operands. On encountering operator, pop two operands and combine as (operand1 operator operand2).
+ A B 
(A + B)

Prefix to Postfix:

- Traverse from right to left.
- Use a stack.
- Push operands. On encountering operator, pop two operands and combine as operand1 operand2 operator.
+ A B 
A B +

## Tips for Remembering

- Postfix → Operator is at the end
- Prefix → Operator is at the beginning
- Stack is the core data structure used in all conversions
- Use parentheses in infix conversions to preserve order
- Operand order matters in prefix/postfix conversions (first popped is right operand)


### Recap Example

(p+q) * (m-n) -> Infix
*+ pq - mn    -> Prefix
pq + mn -*    -> Postfix
