You need to create a Java application that parses a JSON named ‘input.json’, present within the project, of the
format:
{
"institute_name": "xyz",
"student": {
"first_name": "",
"roll_number": ""
}
}
The application should traverse the JSON and pick the value of ‘first_name’ and ‘roll_number’.
The application will produce one output:
MD5 Hash of the string concatenated value of the following: the value of the key first_name and roll_number.
Generate an MD5 hash of the concatenated string.
*Ensure that First name and roll number should be small case only
MD5_HASH( first_name + roll_number )
Note: Keep your first name and roll number in all small case and without spaces. Don’t include Middle name
Eg. If your first name and roll number is Sam and 240350000046 respectively, then the output should be the
result of:
Md5(sam + 24035000040 ) => c719733517bfbdad3b8504213a7f3c96
Store the output in a output.txt file inside you project directory, upload the project link as well as the output.txt
file to the form provided. Ensure the output filename is in small case.

output.txt file will have only one line as output, that is for example:
c719733517bfbdad3b8504213a7f3c96
