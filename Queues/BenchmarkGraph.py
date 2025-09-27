import numpy as np
import matplotlib.pyplot as plt

# Data for appending List A of varying sizes
size_a = [100, 200, 400, 800, 1600, 3200]
time_a = [22.50, 45.81, 93.07, 187.6, 372.3, 745.1]

# Data for appending List B of varying sizes
size_b = [100, 200, 400, 800, 1600, 3200]
time_b = [19.41, 20.04, 21.31, 22.34, 21.27, 22.05]

# Create the plot
plt.figure(figsize=(10, 6))
plt.plot(size_a, time_a, label='Enqueue Time Result', marker='o')
plt.plot(size_b, time_b, label='Dequeue Time Result', marker='s')

# Add titles and labels
plt.title('Initial Queue Benchmark Result')
plt.xlabel('Queue Size')
plt.ylabel('Time (ns)')
plt.yscale('linear')  # Use logarithmic scale for better visibility
plt.grid(True)
plt.legend()

plt.savefig('Benchmark_graph.pdf')  # Save as a PDF file

plt.show()

plt.close()  # Close the plot to avoid display