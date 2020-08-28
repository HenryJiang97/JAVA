import java.util.Queue;
import java.util.Stack;

Queue<Integer> queue = new LinkedList<>();
Stack<Integer> stack = new Stack<>();


// Add to stack
stack.push(a);

// Remove from top of the stack
int a = stack.pop();

// Get but not remove from top of the stack
int a = stack.peek();



// Add to queue
queue.offer(a);

// Remove from head of the queue
int a = queue.poll();

// Get but not remove from head of the queue
int a = queue.peek();