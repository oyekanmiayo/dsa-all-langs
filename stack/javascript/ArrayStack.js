/**
 * @author: AbdulHafeez AbdulRaheem
 */
class ArrayStack {

    constructor() {
        this.entries = [];
        this.top = 0;
    }

    /**
     * @method push
     * @description Add element to the top of the stack
     * @param {*} element 
     */
    push(element)   {
        // Adds a new 
        this.entries[this.top] = element;
        ++this.top;
    }

    /**
     * @method peek
     * @description View the top element of the stack
     */
    peek() {
        //Checks if the stack is empty 
        if(this.isEmpty()) throw new Error("Stack is empty");

        // Returns the element at the top of the stack
        return this.entries[this.top - 1];
    }


    /**
     * @method pop
     * @description Removes element from the of the array
     */
    pop() {
        // Checks if the stack if empty 
        if(this.isEmpty()) throw new Error("Stack is empty");

    
        this.top--;
        return this.entries.pop();
    }

    /**
     * @method: isEmpty
     * @description: Checks if the stack is empty and returns a boolean.
     * @returns Boolean
     */
    isEmpty() {
        return this.top === 0;
    }

    /**
     * @method: view
     * @description Loops through the stack and prints the value
     */
    view() {
        let top = this.top - 1;
        while(top > 0) {
            console.log(this.entries[top]);
            top--;
        }
    }   
}



/**
 * Driver Code
 */

const main = () => {
    let stack = new ArrayStack();
    stack.push(1);
    stack.push(2);
    stack.view();
    stack.pop();
    stack.pop();
}

main();