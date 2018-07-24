package ua.training.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import ua.training.knight.AbstractArmorItem;
import ua.training.knight.AbstractEquipmentItem;
import ua.training.knight.Squire;
import ua.training.knight.interfaces.IEquipmentPiece;

public class Main {

	public static void main(String[] args) {
		Squire sq = new Squire();
		System.out.println(sq.toString());
		
	}
	

}
