package articolo;

import articolo.interfacce.Blog;

public class BlogImp implements Blog {

	private Articolo[] articoli;

	public BlogImp(Articolo[] articoli) {
		this.articoli = articoli;
	}

	@Override
	public void stampaArticoloPerId(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < articoli.length; i++) {
			if (articoli[i].getId() == id)
				System.out.println(articoli[i].toString());
		}
	}

	@Override
	public void stampaArticoli() {
		// TODO Auto-generated method stub
		for (int i = 0; i < articoli.length; i++) {
			System.out.println(articoli[i].toString());
		}
	}

}
