package pe.edu.sistemas.siscadweb.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pe.edu.sistemas.siscadweb.entities.Grupo;
import pe.edu.sistemas.siscadweb.entities.HorarioClase;

public interface HorarioClaseMapper {
	@Select ("select idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio,"
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo,"
			+ "aula as aula,"
			+ "dia as dia,"
			+ "docente_iddocente as idDocente,"
			+ "horario_clase_tipo as horarioClaseTipo,"
			+ "horario_clase_periodo as horarioClasePeriodo "
			+ "from HORARIO_CLASE")
	List<HorarioClase> obtenerHorariosClase();
	
	@Select ("select idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio,"
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo,"
			+ "aula as aula,"
			+ "dia as dia,"
			+ "docente_iddocente as idDocente,"
			+ "horario_clase_tipo as horarioClaseTipo,"
			+ "horario_clase_periodo as horarioClasePeriodo "
			+ "from HORARIO_CLASE "
			+ "where horario_clase_periodo = #{periodo} "
			+ "and dia = #{dia} ")
	List<HorarioClase> obtenerHorariosClasexPeriodoyDia(@Param("periodo") String periodo, @Param("dia") int dia);
	
	@Select ("select idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio,"
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo,"
			+ "aula as aula,"
			+ "dia as dia,"
			+ "docente_iddocente as idDocente,"
			+ "horario_clase_tipo as horarioClaseTipo,"
			+ "horario_clase_periodo as horarioClasePeriodo "
			+ "from HORARIO_CLASE "
			+ "where horario_clase_periodo = #{periodo} "
			+ "and dia = #{dia} "
			+ "and #{hInicio} <= hora_inicio "
			+ "and hora_fin <= #{hFin}")
	List<HorarioClase> obtenerHorariosClasexPeriodoxDiayHora(@Param("periodo") String periodo, @Param("dia") int dia,
															 @Param("hInicio") String hInicio, @Param("hFin") String hFin);

	@Select ("SELECT idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio, "
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo, "
			+ "aula as aula, "
			+ "dia as dia, "
			+ "docente_iddocente as idDocente, "
			+ "horario_clase_tipo as horarioClaseTipo, "
			+ "horario_clase_periodo as horarioClasePeriodo "
			+"from HORARIO_CLASE "
			+"WHERE horario_clase_periodo = #{periodo}  "
			+"AND dia >=  #{diaInicial} "
			+"AND dia <=  #{diaFin} "
			+"AND docente_iddocente =  #{idDocente} ")
	List<HorarioClase> obtenerHorariosClasexPeriodoxDiaxIdDocente(@Param("periodo") String periodo, @Param("diaInicial") int diaInicial,
																  @Param("diaFin") int diaFinal, @Param("idDocente") int idDocente);

	@Select ("SELECT idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio, "
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo, "
			+ "aula as aula, "
			+ "dia as dia, "
			+ "docente_iddocente as idDocente, "
			+ "horario_clase_tipo as horarioClaseTipo, "
			+ "horario_clase_periodo as horarioClasePeriodo "
			+"from HORARIO_CLASE "
			+"WHERE horario_clase_periodo = #{periodo}  "
			+"AND docente_iddocente =  #{idDocente} ")
	List<HorarioClase> obtenerHorariosClasexPeriodoxIdDocente(@Param("periodo") String periodo, 
															 @Param("idDocente") int idDocente);


	@Select ("select idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio,"
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo,"
			+ "aula as aula,"
			+ "dia as dia,"
			+ "docente_iddocente as idDocente,"
			+ "horario_clase_tipo as horarioClaseTipo,"
			+ "horario_clase_periodo as horarioClasePeriodo "
			+ "from HORARIO_CLASE "
			+ "where horario_clase_periodo = #{periodo} "
			+ "and dia = #{dia} "
			+ "and docente_iddocente = #{idDocente} ")
	public List<HorarioClase> obtenerHorariosxDiaxDocentexPeriodo( @Param("dia") int dia,@Param("idDocente")int idDocente,@Param("periodo") String periodo);

	@Select ("select idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio,"
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo,"
			+ "aula as aula,"
			+ "dia as dia,"
			+ "docente_iddocente as idDocente,"
			+ "horario_clase_tipo as horarioClaseTipo,"
			+ "horario_clase_periodo as horarioClasePeriodo "
			+ "from HORARIO_CLASE "
			+ "where grupo_idgrupo = #{grupoId} ")
	public List<HorarioClase> obtenerHorariosxGrupo( @Param("grupoId") int grupoId);

	@Select ("select idhorario_clase as idHorarioClase,"
			+ "hora_inicio as horaInicio,"
			+ "hora_fin as horaFin,"
			+ "grupo_idgrupo as idGrupo,"
			+ "aula as aula,"
			+ "dia as dia,"
			+ "docente_iddocente as idDocente,"
			+ "horario_clase_tipo as horarioClaseTipo,"
			+ "horario_clase_periodo as horarioClasePeriodo "
			+ "from HORARIO_CLASE "
			+ "where grupo_idgrupo = #{idGrupo} "
			+ "and horario_clase_periodo = #{periodo} ")
	public List<HorarioClase> obtenerHorariosxGrupoxDiaxPeriodo(@Param("idGrupo") int idGrupo,
																@Param("periodo") String periodo);
	@Select("select idhorario_clase as idHorarioClase,"
			+ "horario_clase_tipo as horarioClaseTipo"
			+ "from HORARIO_CLASE hc"
			+ "where hc.idhorario_clase=#{idHorarioClase}")
	public HorarioClase obtenerHorarioCasexId(@Param("idHorarioClase") int idHorarioClase);
	
	
	@Insert ("insert into HORARIO_CLASE "
			+ "(GRUPO_IDGRUPO, HORARIO_CLASE_TIPO, DIA, DOCENTE_IDDOCENTE, HORA_INICIO, HORA_FIN, HORARIO_CLASE_PERIODO, AULA, IDHORARIO_CLASE ) "
			+ "VALUES "
			+ "( #{idGrupo}, #{tipoClase}, #{dia}, #{idDocente}, #{horaInicio}, #{horaFin}, #{periodoNombre}, NULL, NULL )")
	void crearNuevoHorario(@Param("idGrupo") int idGrupo,@Param("tipoClase") String tipoClase,@Param("dia") int dia,@Param("idDocente") int idDocente,@Param("horaInicio") String horaInicio,@Param("horaFin") String horaFin,@Param("periodoNombre") String periodoNombre);

}