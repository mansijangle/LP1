import math
import re

class ScreenComplexityCalculator:
    def __init__(self):
        self.elements_count = 0
        self.horizontal_alignments = set()
        self.vertical_alignments = set()

    def add_element(self, row, column):
        self.elements_count += 1
        self.horizontal_alignments.add(column)
        self.vertical_alignments.add(row)

    def calculate_complexity(self):
        horizontal_bits = math.ceil(math.log2(len(self.horizontal_alignments))) if len(self.horizontal_alignments) > 1 else 1
        vertical_bits = math.ceil(math.log2(len(self.vertical_alignments))) if len(self.vertical_alignments) > 1 else 1
        return self.elements_count * (horizontal_bits + vertical_bits)

def extract_grid_parameters_from_gui(file_path):
    # Read the file and extract grid parameters from grid(row=<value>, column=<value>)
    grid_params = []
    with open(file_path, 'r') as file:
        gui_code = file.read()

    # Regular expression to find grid(row=value, column=value)
    pattern = re.compile(r'grid\(\s*row\s*=\s*(\d+)\s*,\s*column\s*=\s*(\d+)\s*[^)]*\)')
    matches = pattern.findall(gui_code)

    # Collect all the (row, column) pairs
    for match in matches:
        row, column = map(int, match)
        grid_params.append((row, column))

    return grid_params

def calc_complexity(self):
    horizontal_bits=math.ceil(math.log2(len(self.horizontal_alignment))) if len(self.horizontal_alignment) > 1 else 1
    vertical_bits = math.ceil(math.log2(len(self.vertical_alignment))) if len(self.vertial_alignment) >1 else 1
    return self.elements_count * (horizontal_bits + vertical_bits)
        
if __name__ == "__main__":
    calculator = ScreenComplexityCalculator()

    # Specify the path to your GUI.py file
    gui_file_path = 'stud_marks.py'

    # Extract grid parameters from the GUI file
    element_grid_params = extract_grid_parameters_from_gui(gui_file_path)

    # Add each element's grid parameters to the calculator
    for row, column in element_grid_params:
        calculator.add_element(row, column)

    # Calculate the complexity of the GUI layout
    complexity = calculator.calculate_complexity()
    print(f"Screen Complexity: {complexity}")
