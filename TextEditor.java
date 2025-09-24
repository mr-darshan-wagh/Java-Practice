import java.util.Scanner;

public class TextEditor{
    private StringBuilder document;

   
    private static class StackArray {
        private String[] stack;
        private int top;
        private static final int MAX_SIZE = 100; // can be adjusted

        public StackArray() {
            stack = new String[MAX_SIZE];
            top = -1;
        }

        public void push(String data) {
            if (top >= MAX_SIZE - 1) {
                System.out.println("Stack overflow!");
                return;
            }
            stack[++top] = data;
        }

        public String pop() {
            if (isEmpty()) {
                return null;
            }
            return stack[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void clear() {
            top = -1;
        }
    }

    private StackArray undoStack;
    private StackArray redoStack;

    public TextEditor() {
        document = new StringBuilder();
        undoStack = new StackArray();
        redoStack = new StackArray();
    }

    public void makeChange(String change) {
        undoStack.push(document.toString());
        document.append(change);
        redoStack.clear();
        System.out.println("\nChange made.");
        displayState();
    }

    public void undoAction() {
        if (!undoStack.isEmpty()) {
            redoStack.push(document.toString());
            document = new StringBuilder(undoStack.pop());
            System.out.println("\nUndo performed.");
        } else { 
            System.out.println("\nNo more actions to undo.");
        }
        displayState();
    }

    public void redoAction() {
        if (!redoStack.isEmpty()) {
            undoStack.push(document.toString());
            document = new StringBuilder(redoStack.pop());
            System.out.println("\nRedo performed.");
        } else {
            System.out.println("\nNo more actions to redo.");
        }
        displayState();
    }

    public void displayState() {
        System.out.println("Current Document State: '" + document.toString() + "'");
    }

    public void runEditor() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Make a Change");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Document State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter text to add: ");
                    String change = scanner.nextLine();
                    makeChange(change);
                    break;
                case "2":
                    undoAction();
                    break;
                case "3":
                    redoAction();
                    break;
                case "4":
                    displayState();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.runEditor();
    }
}