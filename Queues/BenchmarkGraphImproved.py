import numpy as np
import matplotlib.pyplot as plt

# Data for appending List A of varying sizes
queue_sizes = [100, 200, 400, 800, 1600, 3200]
enqueue_times = [21.26, 25.04, 26.27, 22.56, 24.73, 26.13]
# time_a = [21.26, 21.04, 21.27, 21.56, 21.73, 21.13]
dequeue_times = [18.61, 22.34, 23.91, 25.44, 25.97, 27.09]
# time_b = [20.61, 20.34, 20.91, 20.44, 20.97, 20.09]

# Create the plot
plt.figure(figsize=(10, 6))
# Plot enqueue times
plt.plot(queue_sizes, enqueue_times, marker='o', label='Enqueue Time (ns)', color='blue')

# Plot dequeue times
plt.plot(queue_sizes, dequeue_times, marker='s', label='Dequeue Time (ns)', color='orange')

# Add titles and labels
plt.title('Improved Queue Benchmark Result')
plt.xlabel('Queue Size')
plt.ylabel('Time (ns)')

# Set a custom y-axis limit to increase visibility of constant-time operations
plt.ylim(0, 50)  # Set appropriate upper limit for y-axis

#plt.yscale('linear')  # Use logarithmic scale for better visibility
plt.grid(True)
plt.legend()


plt.savefig('Benchmark_graph_improved.pdf')  # Save as a PDF file
plt.show()

plt.close()  # Close the plot to avoid display