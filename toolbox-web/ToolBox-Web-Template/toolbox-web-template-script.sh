#!/bin/zsh

# Get the directory path of the script
SCRIPT_DIRECTORY=$(pwd)

TEMPLATE_FOLDER="TEMPLATES"

# Input files
CONTROLLER_TEMPLATE="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/TemplateRestController.java"
SERVICE_TEMPLATE="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/TemplateService.java"
SERVICEIMPL_TEMPLATE="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/TemplateServiceImpl.java"
MAPPER_TEMPLATE="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/TemplateMapper.java"
REPOSITORY_TEMPLATE="${SCRIPT_DIRECTORY}/${TEMPLATE_FOLDER}/TemplateRepository.java"

TEMPLATES=(${CONTROLLER_TEMPLATE} ${SERVICE_TEMPLATE} ${SERVICEIMPL_TEMPLATE} ${MAPPER_TEMPLATE} ${REPOSITORY_TEMPLATE})

# Check if all the template inputs are present in the SCRIPT_DIRECTORY
for template in "${TEMPLATES[@]}"; do
  if [ ! -f "$template" ]; then
    echo "Error: Input file $template does not exist in the current directory."
    exit 1
  fi
done

# Read input variables
echo "Enter ENTITY: "
read ENTITY
echo "Enter PACKAGE: "
read PACKAGE
echo "Enter ID_TYPE: "
read ID_TYPE

# Create variants of Entity to use for package, type, variable,
ENTITY_LOWERCASE=${ENTITY:l}
#ENTITY_UPPERCASE=${ENTITY:u}
entity_first_char=${ENTITY[1,1]}
entity_rest_chars=${ENTITY[2,-1]}
ENTITY_LOWERCAMELCASE="${entity_first_char:l}${entity_rest_chars}"

echo

# Logs
echo This scipt is configured with:
echo Entity: $ENTITY
echo Package: $PACKAGE
echo Id type: $ID_TYPE

# Declare folders
ENTITY_FOLDER="entity"
DTO_FOLDER="dto"
CONTROLLER_FOLDER="controller"
SERVICE_FOLDER="service"
IMPL_FOLDER="impl"
MAPPER_FOLDER="mapper"
REPOSITORY_FOLDER="repository"

# Create directories
mkdir -p $ENTITY_LOWERCASE
mkdir -p $ENTITY_LOWERCASE/$ENTITY_FOLDER
mkdir -p $ENTITY_LOWERCASE/$DTO_FOLDER
mkdir -p $ENTITY_LOWERCASE/$CONTROLLER_FOLDER
mkdir -p $ENTITY_LOWERCASE/$SERVICE_FOLDER
mkdir -p $ENTITY_LOWERCASE/$SERVICE_FOLDER/$IMPL_FOLDER
mkdir -p $ENTITY_LOWERCASE/$MAPPER_FOLDER
mkdir -p $ENTITY_LOWERCASE/$REPOSITORY_FOLDER

# Output files
CONTROLLER_OUTPUT="${SCRIPT_DIRECTORY}/$ENTITY_LOWERCASE/${CONTROLLER_FOLDER}/${ENTITY}RestController.java"
SERVICE_OUTPUT="${SCRIPT_DIRECTORY}/$ENTITY_LOWERCASE/${SERVICE_FOLDER}/${ENTITY}Service.java"
SERVICEIMPL_OUTPUT="${SCRIPT_DIRECTORY}/$ENTITY_LOWERCASE/${SERVICE_FOLDER}/${IMPL_FOLDER}/${ENTITY}ServiceImpl.java"
MAPPER_OUTPUT="${SCRIPT_DIRECTORY}/$ENTITY_LOWERCASE/${MAPPER_FOLDER}/${ENTITY}Mapper.java"
REPOSITORY_OUTPUT="${SCRIPT_DIRECTORY}/$ENTITY_LOWERCASE/${REPOSITORY_FOLDER}/${ENTITY}Repository.java"

# This array must have the same number of elements and order of TEMPLATES
OUTPUTS=(${CONTROLLER_OUTPUT} ${SERVICE_OUTPUT} ${SERVICEIMPL_OUTPUT} ${MAPPER_OUTPUT} ${REPOSITORY_OUTPUT})

# Calculate the length of the TEMPLATES array
templates_length=${#TEMPLATES[@]}

echo

# Iterate over templates
for (( index=1; index<=templates_length; index++ )); do

  template="${TEMPLATES[index]}"
  output="${OUTPUTS[index]}"

  templateFileName="${template##*/}"
  outputFileName="${output##*/}"
  echo "Creating ${outputFileName} from ${templateFileName}"

  # Read template file, replace placeholders with variables, then write output file
  sed "s/\${PACKAGE}/${PACKAGE}/g; s/\${ID_TYPE}/${ID_TYPE}/g; s/\${ENTITY}/${ENTITY}/g; s/\${ENTITY_LOWERCASE}/${ENTITY_LOWERCASE}/g; s/\${ENTITY_LOWERCAMELCASE}/${ENTITY_LOWERCAMELCASE}/g" ${template} > ${output}
  
  # Check if the sed command was executed correctly
  if [ $? -eq 0 ]; then
    echo "${outputFileName} created correctly"
  else
    echo "Error creating ${outputFileName} from ${templateFileName}"
  fi

  echo

done

echo -e "\033[1;32mScript completed!\033[0m"
echo -e "\033[1;31mPlease consider to check the Mapper before using it.\033[0m"
