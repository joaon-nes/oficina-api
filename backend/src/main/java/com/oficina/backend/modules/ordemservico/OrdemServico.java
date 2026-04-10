package com.oficina.backend.modules.ordemservico;

import com.oficina.backend.modules.cliente.Cliente;
import com.oficina.backend.modules.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ordens_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricaoProblema;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOS status;

    private BigDecimal valorTotal;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;

    @PrePersist
    protected void onCreate() {
        this.dataAbertura = LocalDateTime.now();
        this.status = StatusOS.ABERTA;
    }

    public enum StatusOS {
        ABERTA, EM_ANDAMENTO, AGUARDANDO_PECA, CONCLUIDA, CANCELADA
    }
}