function eliminar(btn) {
    const id = btn.getAttribute("data-id");

    Swal.fire({
        title: "¿Eliminar notificación?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: "Sí, eliminar",
        cancelButtonText: "Cancelar"
    }).then((result) => {
        if (result.isConfirmed) {

            fetch(`/api/notificaciones/${id}`, {
                method: "DELETE"
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Error al eliminar");
                }

                Swal.fire("Eliminado", "La notificación fue eliminada", "success");

                setTimeout(() => location.reload(), 1000);
            })
            .catch(err => {
                console.error(err);
                Swal.fire("Error", "No se pudo eliminar", "error");
            });
        }
    });
}