package prma;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CRUD {
    private Connection conexion;

    public CRUD() {
        conexion = ConexionMySQL.conectar();
    }

    public boolean crearUsuario(String nombre, String usuario, String correo, String contraseña, String departamento) {
        if (nombre.isEmpty() || usuario.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || departamento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuarios (nombre, usuario, correo, contraseña, departamento) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, correo);
            ps.setString(4, contraseña);
            ps.setString(5, departamento);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear usuario: " + e.getMessage());
            return false;
        }
    }
    

    public ArrayList<String[]> obtenerUsuarios() {
        ArrayList<String[]> listaUsuarios = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("usuario");
                fila[3] = rs.getString("correo");
                fila[4] = rs.getString("contraseña");
                fila[5] = rs.getString("departamento");
                listaUsuarios.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.getMessage());
        }
        return listaUsuarios;
    }
    

    public boolean actualizarUsuario(int id, String nombre, String usuario, String correo, String contraseña, String departamento) {
        if (nombre.isEmpty() || usuario.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || departamento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement(
                "UPDATE usuarios SET nombre=?, usuario=?, correo=?, contraseña=?, departamento=? WHERE id=?"
            );
            ps.setString(1, nombre);
            ps.setString(2, usuario);
            ps.setString(3, correo);
            ps.setString(4, contraseña);
            ps.setString(5, departamento);
            ps.setInt(6, id);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(int id) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM usuarios WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    
    // Articulos ALMACEN
    
    public ArrayList<String[]> obtenerAlmacen() {
        ArrayList<String[]> listaAlmacen = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos WHERE categoria = 'Almacén' ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_articulo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("unidad");
                fila[3] = rs.getString("categoria");
                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("stock");
                listaAlmacen.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener articulos de Almacen: " + e.getMessage());
        }
        return listaAlmacen;
    }
    
    
    public boolean eliminarArticulo(int id_articulo) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este articulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM articulos WHERE id_articulo=?");
                ps.setInt(1, id_articulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente.");
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Articulo: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean crearAlmacen(String nombre, String unidad, String categoria, String precio, String stock) {
        if (nombre.isEmpty() || unidad.isEmpty() || categoria.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO articulos (nombre, unidad, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, unidad);
            ps.setString(3, categoria);
            ps.setString(4, precio);
            ps.setString(5, stock);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Articulo registrado exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el Articulo: " + e.getMessage());
            return false;
        }
    }
    
    
    // Articulos COMPRAS
    public ArrayList<String[]> obtenerCompras() {
        ArrayList<String[]> listaCompras = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos WHERE categoria = 'Compras' ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_articulo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("unidad");
                fila[3] = rs.getString("categoria");
                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("stock");
                listaCompras.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener articulos de Compras: " + e.getMessage());
        }
        return listaCompras;
    }
    
    public boolean eliminarCompra(int id_articulo) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este articulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM articulos WHERE id_articulo=?");
                ps.setInt(1, id_articulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente.");
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Articulo: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean crearCompra(String nombre, String unidad, String categoria, String precio, String stock) {
        if (nombre.isEmpty() || unidad.isEmpty() || categoria.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO articulos (nombre, unidad, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, unidad);
            ps.setString(3, categoria);
            ps.setString(4, precio);
            ps.setString(5, stock);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Articulo registrado exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el Articulo: " + e.getMessage());
            return false;
        }
    }
    
    // Articulos Logistica
    public ArrayList<String[]> obtenerLogi() {
        ArrayList<String[]> listalogis = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos WHERE categoria = 'Logística' ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_articulo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("unidad");
                fila[3] = rs.getString("categoria");
                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("stock");
                listalogis.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener articulos de Compras: " + e.getMessage());
        }
        return listalogis;
    }
    
    public boolean eliminaLogis(int id_articulo) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este articulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM articulos WHERE id_articulo=?");
                ps.setInt(1, id_articulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente.");
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Articulo: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean crearLogis(String nombre, String unidad, String categoria, String precio, String stock) {
        if (nombre.isEmpty() || unidad.isEmpty() || categoria.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO articulos (nombre, unidad, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, unidad);
            ps.setString(3, categoria);
            ps.setString(4, precio);
            ps.setString(5, stock);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Articulo registrado exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el Articulo: " + e.getMessage());
            return false;
        }
    }
    
    // Articulos Produccción
    public ArrayList<String[]> obtenerprod() {
        ArrayList<String[]> listaproduc = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos WHERE categoria = 'Producción' ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_articulo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("unidad");
                fila[3] = rs.getString("categoria");
                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("stock");
                listaproduc.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener articulos de Compras: " + e.getMessage());
        }
        return listaproduc;
    }
    
    public boolean eliminaProd(int id_articulo) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este articulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM articulos WHERE id_articulo=?");
                ps.setInt(1, id_articulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente.");
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Articulo: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean crearProd(String nombre, String unidad, String categoria, String precio, String stock) {
        if (nombre.isEmpty() || unidad.isEmpty() || categoria.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO articulos (nombre, unidad, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, unidad);
            ps.setString(3, categoria);
            ps.setString(4, precio);
            ps.setString(5, stock);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Articulo registrado exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el Articulo: " + e.getMessage());
            return false;
        }
    }
    // para RH
    public ArrayList<String[]> obtenerRH() {
        ArrayList<String[]> listarh = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos WHERE categoria = 'Recursos Humanos' ");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_articulo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("unidad");
                fila[3] = rs.getString("categoria");
                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("stock");
                listarh.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener articulos de Compras: " + e.getMessage());
        }
        return listarh;
    }
    
    public boolean eliminaRH(int id_articulo) {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro que deseas eliminar este articulo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps = conexion.prepareStatement("DELETE FROM articulos WHERE id_articulo=?");
                ps.setInt(1, id_articulo);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Articulo eliminado exitosamente.");
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el Articulo: " + e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean crearRH(String nombre, String unidad, String categoria, String precio, String stock) {
        if (nombre.isEmpty() || unidad.isEmpty() || categoria.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            JOptionPane.showMessageDialog(null, "❗ Todos los campos son obligatorios.");
            return false;
        }

        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO articulos (nombre, unidad, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, unidad);
            ps.setString(3, categoria);
            ps.setString(4, precio);
            ps.setString(5, stock);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Articulo registrado exitosamente.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el Articulo: " + e.getMessage());
            return false;
        }
    }
    
    
    //para admin pedidos
    public ArrayList<String[]> obtenerPedidos() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            // Consulta con JOIN entre las tablas pedidos y departamentos_pedido
            String query = "SELECT p.id_pedido, p.nombre, p.precio, p.cantidad, p.total, p.estatus, dp.departamento " +
                           "FROM pedidos p " +
                           "JOIN departamentos_pedido dp ON p.id_pedido = dp.id_pedido ";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[7];
                fila[0] = rs.getString("id_pedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("precio");
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("total");
                fila[5] = rs.getString("estatus");
                fila[6] = rs.getString("departamento");

                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículos: " + e.getMessage());
        }
        return todo;
    }
    
    public ArrayList<String[]> obtenerTodos() {
        ArrayList<String[]> listaTodos = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[6];
                fila[0] = rs.getString("id_articulo");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("unidad");
                fila[3] = rs.getString("categoria");
                fila[4] = rs.getString("precio");
                fila[5] = rs.getString("stock");
                listaTodos.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los articulos: " + e.getMessage());
        }
        return listaTodos;
    }
    
    // pedidos globales. 
    public ArrayList<String[]> obtenerTodo() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM articulos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[2];
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("precio");
                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener articulos: " + e.getMessage());
        }
        return todo;
    }
    
    public void guardarPedidoAlma(String nombre, double precio, int cantidad, double total) {
        String sqlPedido = "INSERT INTO pedidos (nombre, precio, cantidad, total, estatus) VALUES (?, ?, ?, ?, ?)";
    String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

    try (
        Connection conexion = ConexionMySQL.conectar();
        PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);  // Asegúrate de usar Statement.RETURN_GENERATED_KEYS
    ) {
        // Insertar el pedido
        psPedido.setString(1, nombre);
        psPedido.setDouble(2, precio);
        psPedido.setInt(3, cantidad);
        psPedido.setDouble(4, total);
        psPedido.setString(5, "En proceso");
        psPedido.executeUpdate(); // Ejecutar la inserción del pedido

        // Obtener el ID generado automáticamente del pedido
        int idPedido = -1;  // Inicializar la variable
        try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);  // Obtener el ID generado por la base de datos

                // Insertar el departamento 'Almacen' en departamentos_pedido
                try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                    psDepartamento.setInt(1, idPedido);  // Usar el ID generado
                    psDepartamento.setString(2, "Almacen");
                    psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
                }

                // Si todo salió bien
                System.out.println("Pedido guardado con departamento 'Almacen' y con ID " + idPedido);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();  // Si ocurre un error, mostrar detalles
    }
    }
    
    public void guardarPedidoConID(String idPedido, String nombre, double precio, int cantidad, double total) {
       String sqlPedido = "INSERT INTO pedidos (id_pedido, nombre, precio, cantidad, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

        try (Connection conexion = ConexionMySQL.conectar();
             PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

            // Insertar el pedido con el ID proporcionado
            psPedido.setString(1, idPedido);
            psPedido.setString(2, nombre);
            psPedido.setDouble(3, precio);
            psPedido.setInt(4, cantidad);
            psPedido.setDouble(5, total);
            psPedido.executeUpdate(); // Ejecutar la inserción del pedido

            // Insertar en la tabla departamentos_pedido con el mismo idPedido
            try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                psDepartamento.setString(1, idPedido); // El mismo idPedido
                psDepartamento.setString(2, "Almacen");
                psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
            }

            // Si todo salió bien
            System.out.println("Pedido guardado con departamento 'Almacen' y con ID " + idPedido);

        } catch (Exception e) {
            e.printStackTrace(); // Si ocurre un error, mostrar detalles
        }
    }
    public ArrayList<String[]> obtenerPedidoAlmacen() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            // Consulta con JOIN entre las tablas pedidos y departamentos_pedido
            String query = "SELECT p.id_pedido, p.nombre, p.precio, p.cantidad, p.total, p.estatus, dp.departamento " +
                           "FROM pedidos p " +
                           "JOIN departamentos_pedido dp ON p.id_pedido = dp.id_pedido " +
                           "WHERE dp.departamento = 'Almacen'";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[7];
                fila[0] = rs.getString("id_pedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("precio");
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("total");
                fila[5] = rs.getString("estatus");
                fila[6] = rs.getString("departamento");

                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículos: " + e.getMessage());
        }
        return todo;
    }
    // PEDIDOS COMPRAS
    
    public void guardarPedidoCompra(String nombre, double precio, int cantidad, double total) {
        String sqlPedido = "INSERT INTO pedidos (nombre, precio, cantidad, total, estatus) VALUES (?, ?, ?, ?, ?)";
    String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

    try (
        Connection conexion = ConexionMySQL.conectar();
        PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);  // Asegúrate de usar Statement.RETURN_GENERATED_KEYS
    ) {
        // Insertar el pedido
        psPedido.setString(1, nombre);
        psPedido.setDouble(2, precio);
        psPedido.setInt(3, cantidad);
        psPedido.setDouble(4, total);
        psPedido.setString(5, "En proceso");
        psPedido.executeUpdate(); // Ejecutar la inserción del pedido

        // Obtener el ID generado automáticamente del pedido
        int idPedido = -1;  // Inicializar la variable
        try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);  // Obtener el ID generado por la base de datos

                // Insertar el departamento 'Almacen' en departamentos_pedido
                try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                    psDepartamento.setInt(1, idPedido);  // Usar el ID generado
                    psDepartamento.setString(2, "Compras");
                    psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
                }

                // Si todo salió bien
                System.out.println("Pedido guardado con departamento 'Compras' y con ID " + idPedido);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();  // Si ocurre un error, mostrar detalles
    }
    }
    
    public void guardarPedidoConIDCom(String idPedido, String nombre, double precio, int cantidad, double total) {
       String sqlPedido = "INSERT INTO pedidos (id_pedido, nombre, precio, cantidad, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

        try (Connection conexion = ConexionMySQL.conectar();
             PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

            // Insertar el pedido con el ID proporcionado
            psPedido.setString(1, idPedido);
            psPedido.setString(2, nombre);
            psPedido.setDouble(3, precio);
            psPedido.setInt(4, cantidad);
            psPedido.setDouble(5, total);
            psPedido.executeUpdate(); // Ejecutar la inserción del pedido

            // Insertar en la tabla departamentos_pedido con el mismo idPedido
            try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                psDepartamento.setString(1, idPedido); // El mismo idPedido
                psDepartamento.setString(2, "Compras");
                psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
            }

            // Si todo salió bien
            System.out.println("Pedido guardado con departamento 'Compras' y con ID " + idPedido);

        } catch (Exception e) {
            e.printStackTrace(); // Si ocurre un error, mostrar detalles
        }
    }
    public ArrayList<String[]> obtenerPedidoCompras() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            // Consulta con JOIN entre las tablas pedidos y departamentos_pedido
            String query = "SELECT p.id_pedido, p.nombre, p.precio, p.cantidad, p.total, p.estatus, dp.departamento " +
                           "FROM pedidos p " +
                           "JOIN departamentos_pedido dp ON p.id_pedido = dp.id_pedido " +
                           "WHERE dp.departamento = 'Compras'";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[7];
                fila[0] = rs.getString("id_pedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("precio");
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("total");
                fila[5] = rs.getString("estatus");
                fila[6] = rs.getString("departamento");

                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículos: " + e.getMessage());
        }
        return todo;
    }
    // PEDIDOS LOGIS
    
    public void guardarPedidoLogis(String nombre, double precio, int cantidad, double total) {
        String sqlPedido = "INSERT INTO pedidos (nombre, precio, cantidad, total, estatus) VALUES (?, ?, ?, ?, ?)";
    String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

    try (
        Connection conexion = ConexionMySQL.conectar();
        PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);  // Asegúrate de usar Statement.RETURN_GENERATED_KEYS
    ) {
        // Insertar el pedido
        psPedido.setString(1, nombre);
        psPedido.setDouble(2, precio);
        psPedido.setInt(3, cantidad);
        psPedido.setDouble(4, total);
        psPedido.setString(5, "En proceso");
        psPedido.executeUpdate(); // Ejecutar la inserción del pedido

        // Obtener el ID generado automáticamente del pedido
        int idPedido = -1;  // Inicializar la variable
        try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);  // Obtener el ID generado por la base de datos

                // Insertar el departamento 'Almacen' en departamentos_pedido
                try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                    psDepartamento.setInt(1, idPedido);  // Usar el ID generado
                    psDepartamento.setString(2, "Logística");
                    psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
                }

                // Si todo salió bien
                System.out.println("Pedido guardado con departamento 'Logística' y con ID " + idPedido);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();  // Si ocurre un error, mostrar detalles
    }
    }
    
    public void guardarPedidoConIDLog(String idPedido, String nombre, double precio, int cantidad, double total) {
       String sqlPedido = "INSERT INTO pedidos (id_pedido, nombre, precio, cantidad, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

        try (Connection conexion = ConexionMySQL.conectar();
             PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

            // Insertar el pedido con el ID proporcionado
            psPedido.setString(1, idPedido);
            psPedido.setString(2, nombre);
            psPedido.setDouble(3, precio);
            psPedido.setInt(4, cantidad);
            psPedido.setDouble(5, total);
            psPedido.executeUpdate(); // Ejecutar la inserción del pedido

            // Insertar en la tabla departamentos_pedido con el mismo idPedido
            try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                psDepartamento.setString(1, idPedido); // El mismo idPedido
                psDepartamento.setString(2, "Logística");
                psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
            }

            // Si todo salió bien
            System.out.println("Pedido guardado con departamento 'Logística' y con ID " + idPedido);

        } catch (Exception e) {
            e.printStackTrace(); // Si ocurre un error, mostrar detalles
        }
    }
    public ArrayList<String[]> obtenerPedidoLogis() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            // Consulta con JOIN entre las tablas pedidos y departamentos_pedido
            String query = "SELECT p.id_pedido, p.nombre, p.precio, p.cantidad, p.total, p.estatus, dp.departamento " +
                           "FROM pedidos p " +
                           "JOIN departamentos_pedido dp ON p.id_pedido = dp.id_pedido " +
                           "WHERE dp.departamento = 'Logística'";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[7];
                fila[0] = rs.getString("id_pedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("precio");
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("total");
                fila[5] = rs.getString("estatus");
                fila[6] = rs.getString("departamento");

                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículos: " + e.getMessage());
        }
        return todo;
    }
    
    // PEDIDOS PRODUCCION
    
    public void guardarPedidoProd(String nombre, double precio, int cantidad, double total) {
        String sqlPedido = "INSERT INTO pedidos (nombre, precio, cantidad, total, estatus) VALUES (?, ?, ?, ?, ?)";
    String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

    try (
        Connection conexion = ConexionMySQL.conectar();
        PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);  // Asegúrate de usar Statement.RETURN_GENERATED_KEYS
    ) {
        // Insertar el pedido
        psPedido.setString(1, nombre);
        psPedido.setDouble(2, precio);
        psPedido.setInt(3, cantidad);
        psPedido.setDouble(4, total);
        psPedido.setString(5, "En proceso");
        psPedido.executeUpdate(); // Ejecutar la inserción del pedido

        // Obtener el ID generado automáticamente del pedido
        int idPedido = -1;  // Inicializar la variable
        try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);  // Obtener el ID generado por la base de datos

                // Insertar el departamento 'Almacen' en departamentos_pedido
                try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                    psDepartamento.setInt(1, idPedido);  // Usar el ID generado
                    psDepartamento.setString(2, "Produccion");
                    psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
                }

                // Si todo salió bien
                System.out.println("Pedido guardado con departamento 'Produccion' y con ID " + idPedido);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();  // Si ocurre un error, mostrar detalles
    }
    }
    
    public void guardarPedidoConIDProd(String idPedido, String nombre, double precio, int cantidad, double total) {
       String sqlPedido = "INSERT INTO pedidos (id_pedido, nombre, precio, cantidad, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

        try (Connection conexion = ConexionMySQL.conectar();
             PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

            // Insertar el pedido con el ID proporcionado
            psPedido.setString(1, idPedido);
            psPedido.setString(2, nombre);
            psPedido.setDouble(3, precio);
            psPedido.setInt(4, cantidad);
            psPedido.setDouble(5, total);
            psPedido.executeUpdate(); // Ejecutar la inserción del pedido

            // Insertar en la tabla departamentos_pedido con el mismo idPedido
            try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                psDepartamento.setString(1, idPedido); // El mismo idPedido
                psDepartamento.setString(2, "Produccion");
                psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
            }

            // Si todo salió bien
            System.out.println("Pedido guardado con departamento 'Produccion' y con ID " + idPedido);

        } catch (Exception e) {
            e.printStackTrace(); // Si ocurre un error, mostrar detalles
        }
    }
    public ArrayList<String[]> obtenerPedidoProd() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            // Consulta con JOIN entre las tablas pedidos y departamentos_pedido
            String query = "SELECT p.id_pedido, p.nombre, p.precio, p.cantidad, p.total, p.estatus, dp.departamento " +
                           "FROM pedidos p " +
                           "JOIN departamentos_pedido dp ON p.id_pedido = dp.id_pedido " +
                           "WHERE dp.departamento = 'Produccion'";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[7];
                fila[0] = rs.getString("id_pedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("precio");
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("total");
                fila[5] = rs.getString("estatus");
                fila[6] = rs.getString("departamento");

                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículos: " + e.getMessage());
        }
        return todo;
    }
    
      // PEDIDOS RH
    
    public void guardarPedidoRH(String nombre, double precio, int cantidad, double total) {
        String sqlPedido = "INSERT INTO pedidos (nombre, precio, cantidad, total, estatus) VALUES (?, ?, ?, ?, ?)";
    String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

    try (
        Connection conexion = ConexionMySQL.conectar();
        PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS);  // Asegúrate de usar Statement.RETURN_GENERATED_KEYS
    ) {
        // Insertar el pedido
        psPedido.setString(1, nombre);
        psPedido.setDouble(2, precio);
        psPedido.setInt(3, cantidad);
        psPedido.setDouble(4, total);
        psPedido.setString(5, "En proceso");
        psPedido.executeUpdate(); // Ejecutar la inserción del pedido

        // Obtener el ID generado automáticamente del pedido
        int idPedido = -1;  // Inicializar la variable
        try (ResultSet generatedKeys = psPedido.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt(1);  // Obtener el ID generado por la base de datos

                // Insertar el departamento 'Almacen' en departamentos_pedido
                try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                    psDepartamento.setInt(1, idPedido);  // Usar el ID generado
                    psDepartamento.setString(2, "Recursos Humanos");
                    psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
                }

                // Si todo salió bien
                System.out.println("Pedido guardado con departamento 'RH' y con ID " + idPedido);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();  // Si ocurre un error, mostrar detalles
    }
    }
    
    public void guardarPedidoConIDrh(String idPedido, String nombre, double precio, int cantidad, double total) {
       String sqlPedido = "INSERT INTO pedidos (id_pedido, nombre, precio, cantidad, total) VALUES (?, ?, ?, ?, ?)";
        String sqlDepartamento = "INSERT INTO departamentos_pedido (id_pedido, departamento) VALUES (?, ?)";

        try (Connection conexion = ConexionMySQL.conectar();
             PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

            // Insertar el pedido con el ID proporcionado
            psPedido.setString(1, idPedido);
            psPedido.setString(2, nombre);
            psPedido.setDouble(3, precio);
            psPedido.setInt(4, cantidad);
            psPedido.setDouble(5, total);
            psPedido.executeUpdate(); // Ejecutar la inserción del pedido

            // Insertar en la tabla departamentos_pedido con el mismo idPedido
            try (PreparedStatement psDepartamento = conexion.prepareStatement(sqlDepartamento)) {
                psDepartamento.setString(1, idPedido); // El mismo idPedido
                psDepartamento.setString(2, "Recursos Humanos");
                psDepartamento.executeUpdate(); // Ejecutar la inserción del departamento
            }

            // Si todo salió bien
            System.out.println("Pedido guardado con departamento 'rh' y con ID " + idPedido);

        } catch (Exception e) {
            e.printStackTrace(); // Si ocurre un error, mostrar detalles
        }
    }
    public ArrayList<String[]> obtenerPedidoRH() {
        ArrayList<String[]> todo = new ArrayList<>();
        try {
            // Consulta con JOIN entre las tablas pedidos y departamentos_pedido
            String query = "SELECT p.id_pedido, p.nombre, p.precio, p.cantidad, p.total, p.estatus, dp.departamento " +
                           "FROM pedidos p " +
                           "JOIN departamentos_pedido dp ON p.id_pedido = dp.id_pedido " +
                           "WHERE dp.departamento = 'Recursos Humanos'";

            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] fila = new String[7];
                fila[0] = rs.getString("id_pedido");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("precio");
                fila[3] = rs.getString("cantidad");
                fila[4] = rs.getString("total");
                fila[5] = rs.getString("estatus");
                fila[6] = rs.getString("departamento");

                todo.add(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener artículos: " + e.getMessage());
        }
        return todo;
    }
    
}
