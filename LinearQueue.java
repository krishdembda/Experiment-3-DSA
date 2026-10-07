import java.util.Scanner;

public class LinearQueue {

    static int MAX = 5;
    static int[] queue = new int[MAX];
    static int front = -1;
    static int rear = -1;

    // Enqueue: Add customer at the rear
    static void enqueue(Scanner sc) {
        if (rear == MAX - 1) {
            System.out.println("Queue Overflow! Queue is full.");
        } else {
            System.out.print("Enter customer number: ");
            int customer = sc.nextInt();

            if (front == -1) {
                front = 0;
            }

            rear++;
            queue[rear] = customer;

            System.out.println("Customer " + customer + " added to the queue.");
        }
    }

    // Dequeue: Remove customer from the front
    static void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! Queue is empty.");
        } else {
            System.out.println("Customer " + queue[front]
                    + " is served and removed from the queue.");

            front++;

            // Reset queue when it becomes empty
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    // Peek: Show the customer at the front
    static void peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Customer at front: " + queue[front]);
        }
    }

    // Display: Show all customers
    static void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Customers in Queue:");

            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("\n--- Railway Ticket Reservation Queue ---");
            System.out.println("1. Enqueue (Add Customer)");
            System.out.println("2. Dequeue (Serve Customer)");
            System.out.println("3. Peek (Front Customer)");
            System.out.println("4. Display Queue");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    enqueue(sc);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    peek();
                    break;

                case 4:
                    display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}