/* 
 * Author: Miles-Laptop
 * Created: Sep 18, 2025
 */

/* Table for student/person records */
CREATE TABLE IF NOT EXISTS records (
    id TEXT PRIMARY KEY,
    firstname TEXT NOT NULL,
    lastname TEXT NOT NULL,
    age INTEGER NOT NULL,
    address TEXT NOT NULL
);

/* Table for login users */
CREATE TABLE IF NOT EXISTS users (
    username TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);
