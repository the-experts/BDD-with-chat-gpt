from fastapi import FastAPI, HTTPException
from pydantic import BaseModel

app = FastAPI()

class Book(BaseModel):
    title: str
    author: str
    isbn: str
    price: float


books = [
    Book(title="Book 2", author="Author2", isbn="12345", price=20.0)
]

@app.post("/books")
async def create_book(book: Book):
    books.append(book)
    return book

@app.get("/books/{isbn}")
async def read_book(isbn: str):
    for book in books:
        if book.isbn == isbn:
            return book
    raise HTTPException(status_code=404, detail="Book not found")

@app.get("/books")
async def read_books():
    return books

@app.put("/books/{isbn}")
async def update_book(isbn: str, book: Book):
    for i, b in enumerate(books):
        if b.isbn == isbn:
            books[i] = book
            return book
    raise HTTPException(status_code=404, detail="Book not found")

@app.delete("/books/{isbn}")
async def delete_book(isbn: str):
    for i, book in enumerate(books):
        if book.isbn == isbn:
            del books[i]
            return {"detail": "Book deleted successfully"}
    raise HTTPException(status_code=404, detail="Book not found")
