import matplotlib.pyplot as plt

# Data
tree_sizes = [100, 200, 400, 800, 1600, 3200]
recursive_add = [10.50, 15.00, 20.53, 25.04, 31.42, 40.74]
iterative_add = [5.06, 8.46, 12.52, 15.78, 22.46, 31.83]
recursive_lookup = [1.45, 2.06, 2.87, 3.23, 3.92, 4.51]
iterative_lookup = [0.08, 0.12, 0.17, 0.22, 0.28, 0.34]

# Plotting
plt.figure(figsize=(10, 6))

# Plotting the data
plt.plot(tree_sizes, recursive_add, marker='o', label='Recursive Add (ns)', color='lightblue')
plt.plot(tree_sizes, iterative_add, marker='o', label='Iterative Add (ns)', color='black')
plt.plot(tree_sizes, recursive_lookup, marker='o', label='Recursive Lookup (ns)', color='lightgreen')
plt.plot(tree_sizes, iterative_lookup, marker='o', label='Iterative Lookup (ns)', color='orange')

# Adding titles and labels
plt.title('Benchmark Times for Recursive and Iterative Methods')
plt.xlabel('Tree Size')
plt.ylabel('Time (ns)')

plt.xticks(tree_sizes)  # Set x-ticks to the tree sizes

plt.grid(True)
plt.legend()

# Set y-axis limits (for example, from 0 to 50)
# plt.ylim(0, 20)  # Adjust the limits as needed

plt.yscale('log')  # Optional: Use a logarithmic scale for better visibility

# Show plot
plt.tight_layout()
plt.savefig('TreeGraph.pdf')  # Save the plot as an image
plt.show()  # Display the plot

plt.close()  # Close the plot to avoid display