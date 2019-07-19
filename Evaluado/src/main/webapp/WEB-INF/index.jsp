<html>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h3>Menu</h3>
				<h3>
					<td><a href="listaP">Consultar lista de productos</a></td>
				</h3>
				<h3>
					<td><a href="listaProv">Consultar proveedores</a></td>
				</h3>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Productos</h2>

				<h2>Ingrese los datos del producto</h2>
				<form action="proo">
					<table>
						<tr>
							<td>Nombre producto:</td>
							<td><input type="text" name="nombrePro"></td>
						</tr>
						<tr>
							<td>Precio:</td>
							<td><input type="number" name="precio"></td>
						</tr>
						<tr>
							<td>Fecha vencimiento:</td>
							<td><input type="date" name="fechav"></td>
						</tr>
						<tr>
							<td>Categoria:</td>
							<td><input type="number" name="categoria"></td>
						</tr>
						<tr>
							<td>Cantidad:</td>
							<td><input type="number" name="cantidad"></td>
						</tr>
						<tr>
							<td>Proveedor:</td>
							<td><input type="number" name="proveedor"></td>
						</tr>
						<tr>
							<td><input type="submit" name="Guardar" value=Guardar></td>
						</tr>
					</table>
				</form>
			</div>


			<div class="col-6">

				<h2>Proveedores</h2>

				<form action="proveedor">
					<table>
						<tr>
							<td>Nombre proveedor:</td>
							<td><input type="text" name="nombreProv"></td>
						</tr>
						<tr>
							<td>Telefono:</td>
							<td><input type="number" name="telefono"></td>
						</tr>
						<tr>
							<td>Direccion:</td>
							<td><input type="text" name="direccion"></td>
						</tr>
						<tr>
							<td><input type="submit" name="Guardar" value=Guardar></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
