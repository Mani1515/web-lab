from flask import Flask, request, jsonify
import xml.etree.ElementTree as ET

app = Flask(__name__)

# Path to the XML file on the server
XML_FILE_PATH = "books.xml"

# Route to fetch book details
@app.route('/get_book', methods=['GET'])
def get_book_details():
    title = request.args.get('title')  # Get the book title from query parameters
    if not title:
        return jsonify({"error": "Title parameter is missing"}), 400

    try:
        # Parse the XML file
        tree = ET.parse(XML_FILE_PATH)
        root = tree.getroot()

        # Search for the book by title
        for book in root.findall("Book"):
            if book.find("Title").text == title:
                details = {child.tag: child.text for child in book}
                return jsonify(details), 200
        
        # If the book is not found
        return jsonify({"error": "Book not found"}), 404

    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True)
