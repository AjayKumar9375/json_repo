import json

class JsonReader:
    def __init__(self, origin_path, destination_path):
        self.origin_data = self._load_json(origin_path)
        self.destination_path = destination_path

    def _load_json(self, filename):
        try:
            with open(filename, "r") as file:
                data = json.load(file)
            file.close()
            return data
        except json.JSONDecodeError as e:
            print(f"Error parsing JSON: {e}")

    def search_and_dump_data(self, location):
        isFound = False
        for dataset in self.origin_data:
            if location in dataset["location"]:
                isFound = self._dump_data_to_json(dataset)
        if not isFound:
            return "Key not found"
        else:
            return "Operation done"

    def _dump_data_to_json(self, data):
        dest_data = self._load_json(self.destination_path)
        if not dest_data:
            dest_data = []
        dest_data.append(data)
        with open(self.destination_path, "w") as des_file:
            json.dump(dest_data, des_file, indent=4)
        des_file.close()
        return True
