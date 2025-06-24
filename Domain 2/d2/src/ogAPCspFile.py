import random

def get_names():
  exit_code = ":wquit"
  names = []

  print("Enter names seperated by enter")
  print( "To exit type: \":wquit\" ")

  while True:
    name = input("Enter name -> ")


    if name == exit_code or name == "":
      return names

    names.append(name)

def generate_blank_matrix(no):
  return_matrix = []

  for i in range(no):
    return_matrix.append([])

  return return_matrix

def group_by_number_of_groups(no, names):
  groups = generate_blank_matrix(no)

  names_length = len(names)
  no_of_peop_per_group = names_length // no

  temp_names = names

  for i in range(no):
    for j in range(no_of_peop_per_group):
      picked_name = random.choice(temp_names)
      groups[i].append(picked_name)
      temp_names.remove(picked_name)

  if temp_names != []:
    return (groups, temp_names)
  else:
    return (groups, [])

def group_by_group_members(no, names):
  names_length = len(names)
  temp_names = names
  groups = generate_blank_matrix(len(names) // no)

  for i in range(len(groups)):
    for j in range(no):
      picked_name = random.choice(temp_names)
      groups[i].append(picked_name)
      temp_names.remove(picked_name)

  if temp_names != []:
    return (groups, temp_names)
  else:
    return (groups, [])

def pretty_print(matrix):
  print("\n\n\nHere are the Groups and the Extras: ")

  for i in range(len(matrix)):
      string_names = ""

      for name in matrix[i]:
        string_names = string_names + name + " "

      print(f"Group {i+1}: {string_names}")

def main():

  option = input("Enter Grouping Mode:\n1 -> Group by number of groups.\n2 -> Group by number of group members\n: ")
  names = get_names()
  extras = []

  if option == "1":
    no_of_groups = int(input("Enter Number of Groups: "))
    groups = group_by_number_of_groups(no_of_groups, names)
    pretty_print(groups[0])
    if groups[1] != []:
      extras = groups[1]

  elif option == "2":
    no_of_group_members = int(input("Enter Number of Group Members: "))
    groups = group_by_group_members(no_of_group_members, names)
    pretty_print(groups[0])
    if groups[1] != []:
      extras = groups[1]

  else:
    print("ERROR: The option you have entered is not valid, please rerun the program with a valid grouping mode.")
    return

  if extras != []:
    extra_names_string = "There seems to be extra people here they are: "
    for name in extras:
      extra_names_string = extra_names_string + name + " "

    print(extra_names_string)


  continuePrompt = input("Would you like to continue? (y/n)")
  if continuePrompt == "y":
     main()

main()