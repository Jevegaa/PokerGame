import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Clase principal que inicia el juego de poker
public class Poker {
    public static void main(String[] args) {
        // Crear un nuevo deck de cartas
        Deck deck = new Deck();
        deck.shuffle(); // Mezclar el deck
        deck.head();    // Mostrar y remover la primera carta del deck
        deck.pick();    // Seleccionar y remover una carta al azar del deck
        deck.hand();    // Mostrar y remover cinco cartas del deck
    }

    // Clase interna que representa una carta de poker
    public static class Card {
        private String suit; // Palo de la carta (tréboles, corazones, picas, diamantes)
        private String color; // Color de la carta (rojo, negro)
        private String value; // Valor de la carta (2-10, J, Q, K, A)

        // Constructor para inicializar los valores de la carta
        public Card(String suit, String color, String value) {
            this.suit = suit;
            this.color = color;
            this.value = value;
        }

        // Método para convertir la carta a una cadena de texto
        @Override
        public String toString() {
            return suit + "," + color + "," + value;
        }
    }

    // Clase interna que representa un deck de cartas de poker
    public static class Deck {
        private List<Card> cards = new ArrayList<>(); // Lista para almacenar las cartas

        // Constructor para crear el deck y llenarlo con cartas
        public Deck() {
            initializeDeck();
        }

        // Método para inicializar el deck con las 52 cartas de poker
        private void initializeDeck() {
            String[] suits = {"Tréboles", "Corazones", "Picas", "Diamantes"};
            String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
            // Crear cada carta y agregarla al deck
            for (String suit : suits) {
                String color = (suit.equals("Corazones") || suit.equals("Diamantes")) ? "Rojo" : "Negro";
                for (String value : values) {
                    cards.add(new Card(suit, color, value));
                }
            }
        }

        // Método para mezclar las cartas del deck
        public void shuffle() {
            Collections.shuffle(cards);
            System.out.println("Se mezcló el Deck.");
        }

        // Método para mostrar y remover la primera carta del deck
        public void head() {
            if (!cards.isEmpty()) {
                Card card = cards.remove(0);
                System.out.println(card);
                System.out.println("Quedan " + cards.size() + " cartas en el deck.");
            }
        }

        // Método para seleccionar y remover una carta al azar del deck
        public void pick() {
            if (!cards.isEmpty()) {
                int randomIndex = (int) (Math.random() * cards.size());
                Card card = cards.remove(randomIndex);
                System.out.println(card);
                System.out.println("Quedan " + cards.size() + " cartas en el deck.");
            }
        }

        // Método para mostrar y remover cinco cartas del deck
        public void hand() {
            if (cards.size() >= 5) {
                for (int i = 0; i < 5; i++) {
                    Card card = cards.remove(0);
                    System.out.println(card);
                }
                System.out.println("Quedan " + cards.size() + " cartas en el deck.");
            }
        }
    }
}