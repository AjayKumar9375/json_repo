import argparse
from json_reader import JsonReader

def parse_input_arguments():
    parser = argparse.ArgumentParser(description="inputs for script")
    parser.add_argument("--path_to_source_json_file", help="Provide the path to the source json file.", required=True,)
    parser.add_argument("--path_to_destination_json_file", help="Provide the path to the destination json file.", required=True,)
    parser.add_argument("--location_one", type=str, help="Provide the location to be searched in json file.", required=True)
    parser.add_argument("--location_two", type=str, help="Provide the location to be searched in json file.", required=True)
    args = parser.parse_args()
    return args

# This is function   
if __name__ == "__main__":
    configuration = parse_input_arguments()
    json_reader = JsonReader(configuration.path_to_source_json_file, configuration.path_to_destination_json_file)
    print(f"\n {json_reader.search_and_dump_data(configuration.location_one, configuration.location_two)}")
    # print(configuration.location_to_be_searched)

