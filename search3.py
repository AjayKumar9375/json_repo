import argparse
from search4 import JsonReader

def parse_input_arguments():
    parser = argparse.ArgumentParser(description="inputs for script")
    parser.add_argument("--path_to_source_json_file", help="Provide the path to the source json file.", required=True,)
    parser.add_argument("--path_to_destination_json_file", help="Provide the path to the destination json file.", required=True,)
    # parser.add_argument("--location_to_be_searched", type=str, help="Provide the location to be searched in json file.", required=True)
    
    parser.add_argument("--location1", type=str, help="Provide the location to be searched in json file.", required=True)
    parser.add_argument("--location2", type=str, help="Provide the location to be searched in json file.", required=True)
    
    location_to_be_searched = [location1,location2]
    
    args = parser.parse_args()

    location_to_be_searched = [args.location1,args.location2]

    return args


if __name__ == "__main__":
    configuration = parse_input_arguments()
    json_reader = JsonReader(configuration.path_to_source_json_file, configuration.path_to_destination_json_file)
    print(f"\n {json_reader.search_and_dump_data(configuration.location_to_be_searched)}")
    print(configuration.location_to_be_searched)

