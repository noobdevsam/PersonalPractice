# Process Synchronization

In multi-processing systems, when multiple concurrent processes execute and update shared resources, the operating system needs to preserve the order of execution to achieve correct results. This demands that the interacting processes need to execute in a co-ordinated manner. Process synchronization is the procedure that achieves the desired coordination.

## Challenges in Concurrent Execution

*   **Race Conditions:** Concurrent processes accessing shared resources may result in unexpected and erroneous outcomes. For example, if two processes simultaneously write to the same variable, the final value may be unpredictable or incorrect.
*   **Deadlocks:** Processes may become stuck in a state of waiting indefinitely due to resource dependencies. Deadlocks occur when processes are unable to proceed because each process is waiting for a resource held by another process, creating a circular dependency.
*   **Starvation:** A process may be denied access to a shared resource indefinitely, leading to its inability to make progress. This situation arises when certain processes consistently receive priority over others, causing some processes to wait indefinitely for resource access.
*   **Data Inconsistencies:** Inconsistent or incorrect data may occur when processes manipulate shared data concurrently. For example, if multiple processes simultaneously update a database record, the final state of the record may be inconsistent or corrupted.

## Critical Section

A critical section is a code segment where shared variables can be accessed. An atomic action is required in a critical section; only one process can execute in at a time, while all other processes must wait to enter their critical sections.

The critical section contains shared variables or resources that need to be synchronized to maintain data consistency. A critical section is a group of instructions that ensures code execution, such as resource access. If one process tries to access shared data while another thread reads the value simultaneously, the result is unique and unpredictable. Therefore, access to shared variables must be synchronized.

### Critical Section Problem

The critical section problem requires a solution to synchronize different processes. The solution must satisfy the following conditions:

*   **Mutual Exclusion:** Mutual exclusion means only one process can be inside the critical section at a time. If other processes require the critical section, they must wait until it is free. If Pi is executing in its critical section, no other processes can execute in their critical sections: The resources involved are non-shareable. At least one resource must be held in a non-shareable mode i.e, only one process at a time claims exclusive control of the resource. If another process requests that resource, it must be delayed until the resource is released.
*   **Progress:** Progress means that if a process is not using the critical section, it should not prevent other processes from accessing it. In other words, any process can enter the critical section if it is free. If no process can enter the critical section and some processes which to enter their critical sections, only those processes not in their critical sections, only those processes not in their remainder sections can participate in deciding which will enter next. This selection cannot be postponed indefinitely.
*   **Bounded Waiting:** Bounded waiting means that each process must have a limited waiting time and should not wait endlessly to access the critical section. There exists a limit on the number of times that order processes are allowed to enter critical section after a process has requested entry and before that request is granted.

# Synchronization Mechanisms

## Semaphores

Semaphores are synchronization objects that maintain a count and allow or restrict access to resources based on the count value.

A semaphore is a tool used in operating systems to manage different processes that share resources, such as memory or data, without causing conflicts. It provides a unique mechanism for synchronization.

The two atomic operations for semaphores: wait(S), which decrements S and blocks if S is non-positive, and signals(S), which increments S, allowing process synchronization.

The definitions of wait and signal are as follows:

*   **Wait Operation:** The wait operation decrements its argument, S, if it is positive. If S is negative or zero, no operation is performed. This operation checks the semaphore's value. If the value is greater than 0, the process continues and S is decremented by 1. If the value is 0, the process is blocked(waits) until S becomes positive.
*   **Signal Operation:** The signal operation increments its argument, S. After a process finishes using the shared resource, it performs the signal operation, which increases the semaphore's value by 1, potentially unblocking other waiting processes and allowing them to access the resource.

### Types of Semaphores

There are two main types of semaphores: counting semaphores and binary semaphores. Details about these are as follows-

*   **Counting Semaphores:** These integer-value semaphores have an unrestricted value domain. They are used to coordinate resource access, with the semaphore count representing the number of available resources. If resources are added, the semaphore count is incremented automatically; if resources are removed, the count is decremented.
*   **Binary Semaphores:** Binary semaphores are similar to counting semaphores but their value is restricted to 0 and 1. The wait operation only works when the semaphore is 0. Implementing binary semaphores is sometimes easier than counting semaphores.

## Mutual exclusion

In multitasking programming, mutex locks, or mutual exclusion locks, are fundamental synchronization mechanisms used to prevent simultaneous possession of shred resources by multiple threads or processes. The term "mutex" stands for "mutual exclusion".

A mutex lock enables mutual exclusion by limiting the number of threads or processes that can simultaneously acquire the lock. A thread or process that can simultaneously acquire the lock.

A thread or process must first obtain the mutex lock for a shared resource before accessing it. If the lock is held by another thread or process, the requesting thread or process is halted and placed in a waiting state until the lock becomes available. Once the lock is acquired, the thread or process can access the shared resource. Upon completion, it releases the lock, allowing other threads or process to acquire it.

### Components of Mutex Locks

The main components of Mutex Locks are discussed below.

*   **Mutex Variable:** A mutex variable represents the lock. It is a data structure that maintains the lock's state and allows threads or processes to acquire and release it.
*   **Lock Acquisition:** Threads or processes can request the lock. If the lock is available, the requesting thread or process gains ownership of it. Otherwise, it enters a waiting state until the lock becomes available.
*   **Lock Release:** Once a thread or process has finished using the shared resource, it releases the lock, allowing other threads or processes to acquire it.

### Types of Mutex Locks

Mutex locks come in various forms, each offering different levels of capabilities and behavior. Below are a few commonly used types of mutex locks:

*   **Recursive Mutex:** A recursive mutex allows multiple lock acquisitions without blocking a thread or process. It tracks the number of times it was acquired and requires the same number of releases before it can be fully unlocked.
*   **Error-Checking Mutex:** An error-checking mutex performs additional error checking when acquiring a lock. By preventing recursive lock acquisition, it ensures that an application or process does not acquire a mutex lock it already holds.
*   **Times Mutex:** An algorithm or process can attempt to acquire a lock for a predetermined amount of time using a timed mutex. If the lock does not become available within the allotted time, the acquisition attempt fails, allowing the thread or process to respond accordingly.
*   **Priority Inheritance Mutex:** A priority inheritance mutex(also known as a priority ceiling mutex) helps reduce priority inversion issues. It temporarily elevates the priority of the low-priority thread or process holding the lock to the level of the highest-priority thread or process waiting for the lock to be released. This ensures that the low-priority thread or process can complete its task and release the lock, allowing the higher-priority thread or process to proceed.
*   **Read-Write Mutex:** A read-write lock is a synchronization mechanism that allows multiple threads or processes to access the same resource concurrently during read operations while ensuring mutual exclusion during write operations while ensuring mutual exclusion during write operations. Although it shares some similarities with mutex locks, it is not exclusively a type of mutex lock.

### implementation of Mutex Locks

In this example, multiple threads are created to increment a shared resource (shared_resource) by 1. The critical section where the shared resource is modified is protected by a mutex lock (mutex).

Each thread acquires the lock before entering the critical section and releases it after completing the critical section. The mutex lock ensures that only one thread can modify the shared resource at a time, preventing race conditions and ensuring the correctness of the final result.

```python
import threading

# Shared resource
shared_resource = 0

# Mutex lock
mutex = threading.Lock()

# Function to increment the shared resource
def increment():
    global shared_resource
    for _ in range(100000):
        # Acquire the lock
        mutex.acquire()

        # Critical section
        shared_resource += 1

        # Release the lock
        mutex.release()

# Create multiple threads
threads = []
for _ in range(5):
    thread = threading.Thread(target=increment)
    threads.append(thread)

# Start the threads
for thread in threads:
    thread.start()

# Wait for all threads to complete
for thread in threads:
    thread.join()

# Print the final value of the shared resource
print("Shared Resource:", shared_resource)
```

## Bounded Buffer

The Bounded Buffer Problem is a classical issue in computer science, particularly in the content of concurrent programming. The problem involves a fixed-size buffer that can be filled by producers and utilized by consumers. The producers create data and put it into the buffer, and the consumers take data from the buffer to be processed.

### Managing the Bounded Buffer

The difficulty is preventing the producers from trying to insert data when the producers do not try to insert data when the buffer is full and preventing consumers from trying to extract data when the buffer is empty. This chapter underlines the role that synchronization primitives must play to enable these operations safely and economically without allowing race conditions or compromise data integrity. Suggested solutions involving semaphores and other primitives are offered to describe the most effective solution for the Bounded Buffer Problem.

### Key Characteristics

*   **Concurrency Control:** The Bounded Buffer Problem is a fundamental concept in concurrency control, teaching how multiple processes can safely share resources. Understanding this problem is crucial for developing robust multi-threaded applications, as it directly affects hoe well the software handles simultaneous operations.
*   **Blocking and Non-Blocking Solutions:** Blocking solutions utilize condition variables to pause producers when the buffer is full and consumers when it's empty, while non-blocking solutions employ atomic operations to avoid locks, thus improving performance in high-concurrency scenarios.
*   **Semaphore Utilization:** Semaphores are a signaling mechanism by which processes can exchange information regarding the status of the buffer. This decides how the semaphores may be used to regulate access to the buffer to avoid concurrent modifications that may cause data corruption.
*   **Potential Deadlock Issues:** Deadlock situations are possible if several processes are not well coordinated. It emphasizes the value of careful design in coordinating resource allocation so that resources are not waited for infinitely by processes when they are not available.
*   **Error Handling:** Effective error handling mechanisms are vital in dealing with scenarios where the buffer becomes full or empty. The video emphasizes that robust applications must be designed to gracefully handle these conditions to maintain systems stability and prevent crashes.

### Synchronization in concurrent Systems

The Bounded Buffer Problem is a prime example of a synchronization issue in concurrent programming, where multiple processes must share a finite resource safely. The interaction between producers and consumers within a limited buffer encapsulates the challenges of managing data flow in multi-threaded environments.

## Reader-Writer Locks

The reader-writer problem in operating systems deals with managing access to shared data. It allows multiple readers to access the data simultaneously but ensures that only one writer can write at time, with no readers allowed to read during the writing the process.

### Concept of Readers and Writers

The Reader-Writer Problem is a synchronization issue in operating system that manages access to shared data by multiple threads or processes.

*   **Readers:** Processes that only read from the database.
*   **Writers:** Processes that read and modify(write) the database.

### Challenges in Synchronization

The following are the challenges associated with the reader-writer problem in synchronization.

*   **Concurrent Access:** Multiple processes may want to either read or read and write to the database.
*   **Reader-Reader Access:** If two readers access the shared data simultaneously, there is no issue as they only read.
*   **Writer Access:** Problems arise when a writer and another process access the database at the same time.
*   **If a writer is updating the data while a reader is reading, the reader might not read consistent data.**
*   **If two writers access the database simultaneously, conflicting changes can occur.**

### Solution of the Reader-Writer Problem

There are three fundamental solutions to the Readers-Writers problem:

*   **Writer's Preference:** Preference is given to the writers. This means writers arrive, they can proceed with their operations even if readers are currently accessing the resource.
*   **Goal:** The writers have exclusive access to the database,i.e., when a writer is accessing the data, no other process can access it.
*   **Readers Preference:** Preference is given to readers. This means that writers have to wait until readers have finished reading. Writers can only access the resource when no readers are accessing it.

# Monitors in Process Synchronization

Monitors are a synchronization tool used in process synchronization to manage access to shared resources and coordinate the actions of multiple threads or processes. Compared to low-level primitives like locks or semaphores, they provide a higher-level abstraction for handling concurrency.

## Why are Monitors Used?

Monitors are used to prevent concurrent access to shared resources by multiple threads or processes. When several entities attempt to modify the same resource simultaneously, monitors help avoid conflicts and data inconsistencies. They provide a formal method for synchronization, simplifying the design and implementation of concurrent systems.

## How are Monitors Implemented in process Synchronization?

Monitors can be implemented using synchronization primitives such as locks, semaphores, or atomic operation. A lock or mutex associated with a monitor ensures mutual exclusion by allowing only the thread or process holding the lock to access the monitor. Condition variables within the monitor control synchronization and communication.

Threads or processes use condition variables to check condition variables to check conditions and wait for them to become true. When a change to the shared resource satisfies the condition, signaling or notification occurs in the threads or process use condition and wait for them to become true.

![CPU Diagram](https://i.imgur.com/your-image.png)

Programming languages support the use of monitors to achieve process mutual exclusion. For example, Java uses synchronized methods and includes constructs like wait() and notify().

It is a collection of procedures and condition variables assembled into a specific type of module or package.

Although they can invoke monitor procedures, programs running outside of a monitor cannot access its internal variables.

Code inside monitors can only be executed by one process at a time.

## Sleep and Wake in Process Synchronization

In process synchronization, multiple concurrent systems may need to access shared resources while executing code in critical section. over, if more than one process tries to access the critical section simultaneously, it can lead to issues such as data inconsistency or corruption.

To address this, synchronization techniques like the sleep and wake-ip mechanism are used. This approach ensures that processes do not collide while accessing the critical section and that the system operates efficiently without wasting resources like CPU time.

This process arises when a process is blocked until another process wakes it up to resume its execution. The sleep and wakeup mechanisms are managed by two systems calls: sleep() and wakeup().

*   **Sleep():** When a process calls this system call, it gets blocked, managing it suspends its execution until another process wakes it up.
*   **Wakeup():** When another process calls this system call, it triggers the awakening of a process that was previously put to sleep.
