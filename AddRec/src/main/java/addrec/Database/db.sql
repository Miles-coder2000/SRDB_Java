/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Miles-Laptop
 * Created: Sep 18, 2025
 */

CREATE TABLE IF NOT EXISTS records (
    id TEXT PRIMARY KEY,
    firstname TEXT NOT NULL,
    lastname TEXT NOT NULL,
    age INTEGER NOT NULL,
    address TEXT NOT NULL,
);
