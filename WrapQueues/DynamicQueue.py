import matplotlib.pyplot as plt

# Queue sizes and corresponding times
queue_sizes = [100, 200, 400, 800, 1600]
enqueue_times = [09.50, 22.81, 86.07, 18.36, 38.43]
dequeue_times = [07.41, 11.24, 23.51, 11.36, 29.27]

# Create the plot
plt.figure(figsize=(10, 6))

# Plot enqueue times
plt.plot(queue_sizes, enqueue_times, marker='o', label='Enqueue Time (ns)', color='black')

# Plot dequeue times
plt.plot(queue_sizes, dequeue_times, marker='o', label='Dequeue Time (ns)', color='lightgreen')

# Adding titles and labels
plt.title('Enqueue and Dequeue Times for Dynamic Array Queue')
plt.xlabel('Queue Size')
plt.ylabel('Time (ns)')

# Set a custom y-axis limit to increase visibility of constant-time operations
plt.ylim(0, 200)  # Set appropriate upper limit for y-axis

# Add a grid
plt.grid(True)
# Add a legend
plt.legend()

plt.savefig('ArrayQueue_graph.pdf')  # Save as a PDF file
plt.show()

plt.close()  # Close the plot to avoid display

