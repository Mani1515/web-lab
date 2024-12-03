from flask import Flask, request, jsonify
import xml.etree.ElementTree as ET

app = Flask(__name__)

# Path to the XML file on the server
XML_FILE_PATH = "users.xml"

# Route to fetch user details
@app.route('/get_user', methods=['GET'])
def get_user_details():
    user_id = request.args.get('user_id')  # Get the user ID from query parameters
    if not user_id:
        return jsonify({"error": "UserID parameter is missing"}), 400

    try:
        # Parse the XML file
        tree = ET.parse(XML_FILE_PATH)
        root = tree.getroot()

        # Search for the user by UserID
        for user in root.findall("User"):
            if user.find("UserID").text == user_id:
                details = {child.tag: child.text for child in user}
                return jsonify(details), 200
        
        # If the user is not found
        return jsonify({"error": "User not found"}), 404

    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
