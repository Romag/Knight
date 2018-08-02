package ua.training.knight;

public enum Units {
	KILOGRAM {
		@Override
		public String toString() {
			return "kg";
		}
		
	},
	
	FLORIN {
		@Override
		public String toString() {
			return "flr";
		}
	}


}
