# SortingSimulation
Five different sorting techniques have been implemented and compared. The algorithms have been compared on the basis of space complexity, time complexity, degree of data unsortedness. The implementation has been done on 4 different datasets out of which two are real dataset and other two are algorithmically generated.

Description of the implementation
The complete implementation is done using Java. Java library JFreeChart is used to plot all the graphs. A complete automation has been 
done in the implementation i.e. the submitted code runs all the simulations (4 data sets x 2 perf measures x 2 parameters) on a single click.

Sorting Algorithms
Five sorting algorithms were used for comparation.

1. Insertion sort
Insertion sort is quite intuitive sorting algorithm in which we iterate over the data set, comparing each entry by each of its 
previous entries are place it where it belongs. Since each element is compared with on an average n/2 element, it has a quadratic 
time complexity (i.e., O(𝑛2)).

2. Selection Sort
Selection sort also known as in-place comparison sort is the most intuitive sorting algorithm which sorts an array by finding the 
minimum element from the array and putting it in the front and repeating the process in the remaining array. This algorithm again has
a quadratic time complexity as finding the least entry takes n-1 comparisons for n elements.

3. Bubble sort
Bubble sort is another simple sorting technique also known as sinking sort. It repeatedly swaps the adjacent elements if they are in 
wrong order i.e. swaps if a latter entry is smaller than the former one (assuming we are sorting in increasing order). It also has a 
time complexity of O(𝑛2).

4. Merge sort
Merge sort is based on divide and conquer. It divides the array in two parts and keeps on repeating the process till it split the entire
array into single entities then it merges the entities to form the complete sorted array. This algorithm has an advantage in terms of time
complexity as the splitting and merging has an overall complexity of 𝑂(𝑛𝑙𝑜𝑔𝑛).

5. Quick sort
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the 
picked pivot. The algorithm takes O(n log n) comparisons to sort n items.

Data sets
Four different data sets have been used for the comparison purpose. Out of the four, two are real data sets whereas the remaining two are synthetically generated. The description of the data sets is given below:
1) Synthetically generated: size 100,000 ranging from 100 to 1,000,000
2) Synthetically generated: size 100,000 ranging from 0 to 10,000
3) 100,000 sales report where field ‘unit sold’ is used for the sorting purpose. The field ranges from 1 to 10,000.
4) Weather station data of rain-forest. ‘Temperature’ field is used. The dataset size is 100,000 and it ranges from -180 to 179.


