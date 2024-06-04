import json

class JsonReader:
    def __init__(self, origin_path, destination_path):
        self.origin_data = self._load_json(origin_path)
        self.destination_path = destination_path

    def _load_json(self, filename):
        try:
            with open(filename, "r") as file:
                data = json.load(file)
            return data
        except FileNotFoundError:
            print(f"Error: The file {filename} was not found.")
            return []
        except json.JSONDecodeError as e:
            print(f"Error parsing JSON in {filename}: {e}")
            return []
        except Exception as e:
            print(f"An error occurred while loading the file {filename}: {e}")
            return []

    def search_and_dump_data(self, location1, location2):
        locations = [location1, location2]
        isFound = False
        for location in locations:
            for dataset in self.origin_data:
                if location in dataset.get("location", ""):
                    if self._dump_data_to_json(dataset):
                        isFound = True

        return "Operation done" if isFound else "Key not found"

    def _dump_data_to_json(self, data):
        dest_data = self._load_json(self.destination_path)
        if not dest_data:
            dest_data = []
        dest_data.append(data)
        try:
            with open(self.destination_path, "w") as des_file:
                json.dump(dest_data, des_file, indent=4)
            return True
        except Exception as e:
            print(f"An error occurred while writing to the file {self.destination_path}: {e}")
            return False
