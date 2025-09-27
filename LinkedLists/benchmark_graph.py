import numpy as np
import matplotlib.pyplot as plt

# Data for appending List A of varying sizes
size_a = [100, 200, 400, 800, 1600, 3200, 6400]
time_a = [40.4, 83.32, 171.14, 335.61, 672.3, 1365.06, 2739.36]

# Data for appending List B of varying sizes
size_b = [100, 200, 400, 800, 1600, 3200, 6400]
time_b = [42.04, 44.34, 44.24, 43.26, 43.5, 43.73, 43.42]

# Create the plot
plt.figure(figsize=(10, 6))
plt.plot(size_a, time_a, label='Append varying size A', marker='o')
plt.plot(size_b, time_b, label='Append fixed size A to varying size B', marker='s')

# Add titles and labels
plt.title('Benchmarking Linked List Append Operation')
plt.xlabel('Size of List (A or B)')
plt.ylabel('Time (nanoseconds)')
plt.yscale('linear')  # Use logarithmic scale for better visibility
plt.grid(True)
plt.legend()

plt.savefig('append_benchmark_graph.pdf')  # Save as a PDF file

plt.show()

plt.close()  # Close the plot to avoid display