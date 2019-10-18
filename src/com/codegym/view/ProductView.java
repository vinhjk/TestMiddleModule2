package com.codegym.view;

import com.codegym.controller.ProductController;
import com.codegym.model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Products List Program");
        ProductController productController = new ProductController();
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    List<Product> productList = productController.getProducts();
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getId() +
                                " NAME: " + product.getName() +
                                " PRICE: " + product.getPrice() +
                                " STATUS: " + product.getStatus() +
                                " DESCRIPTION: " +product.getDescription()
                        );
                    }
                    break;
                }
                case 2: {
                    System.out.println("Add new product :");
                    Product productObject = inputProduct();
                    productController.addProduct(productObject);
                    break;

                }

                case 3:{
                    System.out.println("Remove product with ID = ");
                    int idInput = scanner.nextInt();
                    Product productObject = inputProduct();
                    productController.editProduct(idInput,productObject);
                    break;
                }
                case 4:
                {
                    System.out.println("Delete product with ID = ");
                    int idInput = scanner.nextInt();
                    productController.deleteProduct(idInput);
                    break;
                }
                case 5:
                {
                    /////Search by name
                    System.out.println("Search product by name : ");
                    scanner.nextLine();
                    String nameInput = scanner.nextLine();
                    Product p = productController.searchByName(nameInput);
                    if (p== null) {
                        System.out.println("Product was not found:"+nameInput);
                    } else {
                        System.out.println("Product was found:"+p);
                    }
                    break;
                }
                case 6:
                {
                    System.out.println("Product increases by price :");
                    productController.sortDescending();
                    break;
                }
                case 7:
                {
                    System.out.println("Product descending by price");
                    productController.sortAscending();
                    break;
                }
            }

        } while (choice != 0);
    }
    private static void menu() {
        System.out.println("1. Show list products.");
        System.out.println("2. Add new product.");
        System.out.println("3. Remove product.");
        System.out.println("4. Delete product.");
        System.out.println("5. Search product by name.");
        System.out.println("6. Product increases by price.");
        System.out.println("7. Product descending by price.");
        System.out.println("0. Exit");
        System.out.println("Choose feature:");
    }

    private static Product inputProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter price:");
        float price = input.nextFloat();
        input.nextLine();
        System.out.println("Enter status:");
        String status = input.nextLine();
        System.out.println("Enter description:");
        String description = input.nextLine();

        Product product = new Product(id, name, price,status,description);
        return product;
    }
}
